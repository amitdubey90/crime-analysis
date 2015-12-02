package com.example.dao.impl;

import com.example.bean.IncidentMonthCount;
import com.example.bean.IncidentTypeCount;
import com.example.dao.CountDaoIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CountDaoImpl implements CountDaoIfc {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<IncidentTypeCount> getIncidentCountsByType() {
        List<IncidentTypeCount> resultList = null;
        try {
            resultList = jdbc.query("select * from incident_type_count", typeCountRowMapper);
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

    private static BeanPropertyRowMapper<IncidentTypeCount> typeCountRowMapper = new BeanPropertyRowMapper<IncidentTypeCount>() {

        public IncidentTypeCount mapRow(ResultSet resultSet, int i) throws SQLException {
            IncidentTypeCount incident = new IncidentTypeCount();
            incident.setRowId(resultSet.getInt("rowId"));
            incident.setType(resultSet.getString("type"));
            incident.setCount(resultSet.getInt("incidentCount"));

            System.out.println(incident);
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

            System.out.println(incident);
            return incident;
        }
    };
}
