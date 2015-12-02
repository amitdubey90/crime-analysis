package com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.IncidentHourlyCount;
import com.example.bean.IncidentLocationCount;
import com.example.bean.IncidentMonthCount;
import com.example.bean.IncidentTypeCount;
import com.example.dao.CountDaoIfc;

@Repository
public class CountDaoImpl implements CountDaoIfc {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<IncidentTypeCount> getIncidentCountsByType() {
        List<IncidentTypeCount> resultList = null;
        try {
            resultList = jdbc.query("select * from crimetypecount group by content", typeCountRowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public List<IncidentMonthCount> getIncidentCountsByMonth() {
        List<IncidentMonthCount> resultList = null;
        try {
            resultList = jdbc.query("SELECT SUM(incidentcount), month FROM incident_monthly_count GROUP BY month", monthCountRowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public List<IncidentHourlyCount> getIncidentCountsByHour() {
        List<IncidentHourlyCount> resultList = null;
        try {
            resultList = jdbc.query("select * from crimeHourlyCount group by hour", hourCountRowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    
    @Override
	public List<IncidentLocationCount> getIncientCountsByLocation() {
    	
    	List<IncidentLocationCount> resultList =  null;
    	
    	try {
    		resultList =  jdbc.query("SELECT * FROM locationcrimecount ", locationCountMapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
     
    	return resultList;

	}
    private static BeanPropertyRowMapper<IncidentTypeCount> typeCountRowMapper = new BeanPropertyRowMapper<IncidentTypeCount>() {

        public IncidentTypeCount mapRow(ResultSet resultSet, int i) throws SQLException {
            IncidentTypeCount incident = new IncidentTypeCount();
            incident.setRowId(resultSet.getInt("id"));
            incident.setType(resultSet.getString("content"));
            incident.setCount(resultSet.getInt("count"));

            return incident;
        }
    };

    private static BeanPropertyRowMapper<IncidentMonthCount> monthCountRowMapper = new BeanPropertyRowMapper<IncidentMonthCount>() {

        public IncidentMonthCount mapRow(ResultSet resultSet, int i) throws SQLException {
            IncidentMonthCount incident = new IncidentMonthCount();
            incident.setRowId(resultSet.getInt("rowId"));
            incident.setMonth(resultSet.getInt("month"));
            incident.setYear(resultSet.getInt("year"));
            incident.setCount(resultSet.getInt("incidentCount"));

            return incident;
        }
    };

    private static BeanPropertyRowMapper<IncidentHourlyCount> hourCountRowMapper = new BeanPropertyRowMapper<IncidentHourlyCount>() {

        public IncidentHourlyCount mapRow(ResultSet resultSet, int i) throws SQLException {
            IncidentHourlyCount incident = new IncidentHourlyCount();
            incident.setId(resultSet.getInt("id"));
            incident.setHour(resultSet.getInt("hour"));
            incident.setCount(resultSet.getInt("count"));

            return incident;
        }
    };
    

	private static BeanPropertyRowMapper<IncidentLocationCount> locationCountMapper = new BeanPropertyRowMapper<IncidentLocationCount>(){
		public IncidentLocationCount mapRow(ResultSet resultSet, int i) throws SQLException {
            IncidentLocationCount incident = new IncidentLocationCount();
            incident.setRowId(resultSet.getInt("rowId"));
            incident.setLatitude(resultSet.getLong("latitude"));
            incident.setLongitude(resultSet.getLong("longitude"));
            incident.setCount(resultSet.getInt("count"));
            System.out.println(incident);
            return incident;
        }
	};
}
