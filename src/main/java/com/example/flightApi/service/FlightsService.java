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

  public List<Flights> queryFlights(Long departure_airport_id, Long destination_airport_id, Date departure_date) {
    return flightsRepository.queryFlights(departure_airport_id, destination_airport_id, departure_date);
  }
}
