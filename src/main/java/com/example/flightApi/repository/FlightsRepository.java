package com.example.flightapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightapi.entity.FlightEntity;

@Repository
public interface FlightsRepository extends JpaRepository<FlightEntity, Long> {
  // for study. This is same as "findByDepCityAndDesCityAndDepartureDate".
  // default List<FlightEntity> queryFlights(String dep_city, String des_city,
  // Date departure_date) {
  // FlightEntity flight = new FlightEntity();
  // flight.setDepCity(dep_city);
  // flight.setDesCity(des_city);
  // flight.setDepartureDate(departure_date);
  // ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
  // Example<FlightEntity> exampleToFlights = Example.of(flight, matcher);
  // return this.findAll(exampleToFlights);
  // }

  List<FlightEntity> findByDepCityAndDesCityAndDepartureDate(String dep_city, String des_city, Date departure_date);

  List<FlightEntity> findByFlightId(Long flight_id);

  List<FlightEntity> findByFlightIdOrFlightId(Long flight_id_dep, Long flight_id_des);

}
