package com.example.dao.impl;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.example.bean.Points;
import com.example.dao.LocationDaoIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDaoIfc {

    @Autowired
    JdbcTemplate jdbc;


    public List<Points> getPoints2(String typeOfCrime) {
        List<Points> resultList = null;
        try {
            resultList = jdbc.query("select latitude, longitude, count from crimelocationcount", pointsRowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public List<Points> getPoints(String typeOfCrime) {
        List<Points> resultList = null;
        System.out.println("from new points");
        try {
            resultList = jdbc.query("select latitude, longitude from newcrimelocationcount", pointsRowMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    private static BeanPropertyRowMapper<Points> pointsRowMapper = new BeanPropertyRowMapper<Points>() {

        public Points mapRow(java.sql.ResultSet resultSet, int i) throws SQLException {
            Points p = new Points();
            p.setLatitude(resultSet.getDouble("latitude"));
            p.setLongitude(resultSet.getDouble("longitude"));
            //p.setWeight(resultSet.getInt("count"));
            return p;
        }
    };

    public List<Points> getPointsCassandra(String typeOfCrime) {
        System.out.println("Getting points from location Dao");
        List pointLists = new ArrayList<Points>();
        Cluster cluster = null;
        Points p = null;

        try {
            // Connect to the cluster and keyspace "cmpe297"
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            Session session = cluster.connect("cmpe297");

            ResultSet results = session.execute("SELECT latitude, longitude FROM crimedataset limit 1000");

            for (Row row : results) {
                //p = new Points(row.getDouble(0), row.getDouble(1));
                pointLists.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            cluster.close();
            return pointLists;
        }
    }
}
