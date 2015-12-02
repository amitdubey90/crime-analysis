package com.example.bean.wrapper;

import com.example.bean.IncidentTypeCount;

import java.util.List;

public class IncidentTypeCountWrapper {
    private List<IncidentTypeCount> crime;

    public IncidentTypeCountWrapper(List<IncidentTypeCount> crime) {
        this.crime = crime;
    }

    public List<IncidentTypeCount> getCrime() {
        return crime;
    }

    public void setCrime(List<IncidentTypeCount> crime) {
        this.crime = crime;
    }
}
