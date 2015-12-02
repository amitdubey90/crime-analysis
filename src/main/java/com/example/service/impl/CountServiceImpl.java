package com.example.service.impl;

import com.example.bean.IncidentHourlyCount;
import com.example.bean.IncidentMonthCount;
import com.example.bean.IncidentTypeCount;
import com.example.dao.CountDaoIfc;
import com.example.service.CountServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountServiceImpl implements CountServiceIfc {

    @Autowired
    CountDaoIfc countDao;

    @Override
    public List<IncidentTypeCount> getIncidentCountsByType() {
        return countDao.getIncidentCountsByType();
    }

    @Override
    public List<IncidentMonthCount> getIncidentCountsByMonth() {
        return countDao.getIncidentCountsByMonth();
    }

    @Override
    public List<IncidentHourlyCount> getIncidentCountsByHour() {
        return countDao.getIncidentCountsByHour();
    }
}
