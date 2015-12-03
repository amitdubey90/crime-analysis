package com.example.controller;

import com.example.bean.Points;
import com.example.service.LocationServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationServiceController {

    @Autowired
    LocationServiceIfc locationService;

    @RequestMapping(value="/getPoints", method = RequestMethod.GET)
    public List<Points> getPoints(@RequestParam(required = false, value = "all") String typeOfCrime ) {
        return locationService.getPoints(typeOfCrime);
    }
}