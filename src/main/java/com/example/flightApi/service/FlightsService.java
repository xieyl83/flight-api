package com.example.flightApi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightApi.entity.Flights;
import com.example.flightApi.repository.FlightsRepository;

@Service
public class FlightsService {
  @Autowired
  private FlightsRepository flightsRepository;

  public List<Flights> queryFlights(String dep_city, String des_city, Date departure_date) {
    return flightsRepository.queryFlights(dep_city, des_city, departure_date);
  }
}
