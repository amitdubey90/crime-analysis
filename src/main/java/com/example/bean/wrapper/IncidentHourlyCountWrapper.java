package com.example.bean.wrapper;

import com.example.bean.IncidentHourlyCount;

import java.util.List;

public class IncidentHourlyCountWrapper {
    private List<IncidentHourlyCount> hourly;

    public IncidentHourlyCountWrapper(List<IncidentHourlyCount> hourly) {
        this.hourly = hourly;
    }

    public List<IncidentHourlyCount> getHourly() {
        return hourly;
    }

    public void setHourly(List<IncidentHourlyCount> hourly) {
        this.hourly = hourly;
    }
}
