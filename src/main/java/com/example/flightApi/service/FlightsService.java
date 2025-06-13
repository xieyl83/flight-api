package com.example.flightapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightapi.entity.FlightEntity;
import com.example.flightapi.repository.FlightsRepository;

@Service
public class FlightsService {
  @Autowired
  private FlightsRepository flightsRepository;

  public List<FlightEntity> queryFlights(String dep_city, String des_city, Date departure_date) {
    return flightsRepository.findByDepCityAndDesCityAndDepartureDate(dep_city,
        des_city, departure_date);
  }

  public List<FlightEntity> queryFlightsForBookSingleTrip(Long flight_id_dep) {
    return flightsRepository.findByFlightId(flight_id_dep);
  };

  public List<FlightEntity> queryFlightsForBookRoundTrip(Long flight_id_dep, Long flight_id_des) {
    return flightsRepository.findByFlightIdOrFlightId(flight_id_dep, flight_id_des);
  };

}
