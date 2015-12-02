package com.example.service.impl;

import com.example.bean.Points;
import com.example.dao.LocationDaoIfc;
import com.example.service.LocationServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationServiceIfc {

    @Autowired
    LocationDaoIfc locationDao;

    @Override
    public List<Points> getPoints(String typeOfCrime) {
        return locationDao.getPoints(typeOfCrime);
    }
}
