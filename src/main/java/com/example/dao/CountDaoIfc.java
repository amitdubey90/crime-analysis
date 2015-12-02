package com.example.dao;

import com.example.bean.IncidentMonthCount;
import com.example.bean.IncidentTypeCount;

import java.util.List;

public interface CountDaoIfc {
    List<IncidentTypeCount> getIncidentCountsByType();

    List<IncidentMonthCount> getIncidentCountsByMonth();
}
