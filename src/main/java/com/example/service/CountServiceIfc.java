package com.example.service;

import com.example.bean.IncidentMonthCount;
import com.example.bean.IncidentTypeCount;

import java.util.List;

public interface CountServiceIfc {
    List<IncidentTypeCount> getIncidentCountsByType();

    List<IncidentMonthCount> getIncidentCountsByMonth();
}
