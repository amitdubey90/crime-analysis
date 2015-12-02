package com.example.service;

import com.example.bean.Points;

import java.util.List;

public interface LocationServiceIfc {
    List<Points> getPoints(String typeOfCrime);
}