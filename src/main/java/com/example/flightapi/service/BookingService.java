package com.example.flightapi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.flightapi.entity.BookingEntity;
import com.example.flightapi.pojo.BookFlightRequestData;

public interface BookingService {

  @Transactional
  public BookingEntity bookSingleTrip(BookFlightRequestData flight, Long userId,
      String reference);

  @Transactional
  public List<BookingEntity> bookRoundTrip(BookFlightRequestData flight_dep, BookFlightRequestData flight_des,
      Long userId, String reference);

}
