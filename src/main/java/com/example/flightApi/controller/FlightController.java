package com.example.flightApi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightApi.entity.Flights;
import com.example.flightApi.service.FlightsService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
  @Autowired
  private FlightsService flightsService;

  @GetMapping
  public List<Flights> getFlights(@RequestParam("dep") String dep_city, @RequestParam("des") String des_city,
      @RequestParam("depDate") String depDate) {
    // todo: validate input

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d = null;
    try {
      d = new Date(sdf.parse(depDate).getTime());
    } catch (ParseException e) {
      // todo: response errors to client
      e.printStackTrace();
    }
    return flightsService.queryFlights(dep_city, des_city, d);
  }
}
