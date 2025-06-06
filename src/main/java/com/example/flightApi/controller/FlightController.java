package com.example.flightApi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightApi.entity.Flights;
import com.example.flightApi.service.FlightsService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
  @Autowired
  private FlightsService flightsService;

  @GetMapping
  public List<Flights> getFlights() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d = null;
    try {
      d = new Date(sdf.parse("2025-07-01").getTime());
    } catch (ParseException e) {
      // will not happen
      e.printStackTrace();
    }
    return flightsService.queryFlights(Long.valueOf(1L), Long.valueOf(2L), d);
  }
}
