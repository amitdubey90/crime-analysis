package com.example.bean;

import java.util.Date;

//@Table(value = "test")
public class Incident {
    /*@PrimaryKey private String incidentId;
    @Column private String dateOfIncident;
    @Column private String timeOfIncident;
    @Column private String latitude;
    @Column private String longitude;*/

    private int incidentId;
    private Date incidentTimeStamp;
    private long latitude;
    private long longitude;

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public Date getIncidentTimeStamp() {
        return incidentTimeStamp;
    }

    public void setIncidentTimeStamp(Date incidentTimeStamp) {
        this.incidentTimeStamp = incidentTimeStamp;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "incidentId=" + incidentId +
                ", incidentTimeStamp=" + incidentTimeStamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
