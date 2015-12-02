package com.example.dao.impl;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.example.bean.Points;
import com.example.dao.LocationDaoIfc;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDaoIfc {

    @Override
    public List<Points> getPoints(String typeOfCrime) {
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
                p = new Points(row.getDouble(0), row.getDouble(1));
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
