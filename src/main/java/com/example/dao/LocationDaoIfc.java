package com.example.dao;

import com.example.bean.Points;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LocationDaoIfc {
    public List<Points> getPoints(String typeOfCrime);
}