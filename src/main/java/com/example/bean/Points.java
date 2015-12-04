package com.example.bean;

public class Points {
    private Double latitude;
    private Double longitude;
    private int weight;

    public Points(){}

    public Points(Double latitude, Double longitude, int weight) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.weight = weight;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
