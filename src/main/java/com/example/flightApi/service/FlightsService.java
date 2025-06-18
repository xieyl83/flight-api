package com.example.flightapi.service;

import java.sql.Date;
import java.util.List;

import com.example.flightapi.entity.FlightEntity;

public interface FlightsService {

  public List<FlightEntity> queryFlights(String dep_city, String des_city, Date departure_date);

  public List<FlightEntity> queryFlightsForBookSingleTrip(Long flight_id_dep);

  public List<FlightEntity> queryFlightsForBookRoundTrip(Long flight_id_dep, Long flight_id_des);

}
