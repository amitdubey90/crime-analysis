package com.example.dao;

import java.util.List;

import com.example.bean.IncidentHourlyCount;
import com.example.bean.IncidentLocationCount;
import com.example.bean.IncidentMonthCount;
import com.example.bean.IncidentTypeCount;

public interface CountDaoIfc {
    List<IncidentTypeCount> getIncidentCountsByType();

    List<IncidentMonthCount> getIncidentCountsByMonth();

    List<IncidentHourlyCount> getIncidentCountsByHour();
    
    List<IncidentLocationCount> getIncientCountsByLocation();

    List<IncidentMonthCount> getMonthlyCountForDrill();
}
