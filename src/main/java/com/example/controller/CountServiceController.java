package com.example.controller;

import com.example.bean.IncidentMonthCount;
import com.example.bean.wrapper.IncidentHourlyCountWrapper;
import com.example.bean.wrapper.IncidentTypeCountWrapper;
import com.example.service.CountServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getCount")
public class CountServiceController {

    @Autowired
    CountServiceIfc countService;

    @RequestMapping("/byType")
     public IncidentTypeCountWrapper getIncidentCountsByType() {
        return new IncidentTypeCountWrapper(countService.getIncidentCountsByType());
    }

    @RequestMapping("/byMonth")
    public List<IncidentMonthCount> getIncidentCountsByMonth() {
        return countService.getIncidentCountsByMonth();
    }

    @RequestMapping("/byHour")
    public IncidentHourlyCountWrapper getIncidentCountsByHour() {
        return new IncidentHourlyCountWrapper(countService.getIncidentCountsByHour());
    }
}
