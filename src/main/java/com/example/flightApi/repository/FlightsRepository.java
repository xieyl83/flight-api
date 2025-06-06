package com.example.flightApi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightApi.entity.Flights;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {
  default List<Flights> queryFlights(String dep_city, String des_city, Date departure_date) {
    Flights flights = new Flights();
    flights.setDep_city(dep_city);
    flights.setDes_city(des_city);
    flights.setDeparture_date(departure_date);
    ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
    Example<Flights> exampleToFlights = Example.of(flights, matcher);
    return this.findAll(exampleToFlights);
  }
}
