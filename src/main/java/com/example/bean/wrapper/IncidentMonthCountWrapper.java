package com.example.bean.wrapper;

import com.example.bean.IncidentMonthCount;

import java.util.List;

public class IncidentMonthCountWrapper {
    private List<IncidentMonthCount> monthlyCount;

    public IncidentMonthCountWrapper(List<IncidentMonthCount> monthlyCount) {
        this.monthlyCount = monthlyCount;
    }

    public List<IncidentMonthCount> getMonthlyCount() {
        return monthlyCount;
    }

    public void setMonthlyCount(List<IncidentMonthCount> monthlyCount) {
        this.monthlyCount = monthlyCount;
    }
}
