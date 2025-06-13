package com.example.flightapi.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.flightapi.entity.BookingEntity;
import com.example.flightapi.entity.FlightEntity;
import com.example.flightapi.pojo.BookFlightRequestData;
import com.example.flightapi.repository.BookingRequestRepository;
import com.example.flightapi.repository.FlightsRepository;

@Service
public class BookingService {
  @Autowired
  private BookingRequestRepository bookingRequestRepository;

  @Autowired
  private FlightsRepository flightsRepository;

  @Transactional
  public BookingEntity bookSingleTrip(BookFlightRequestData flight, Long userId,
      String reference) {
    List<FlightEntity> flightData = flightsRepository.findByFlightId(flight.getFlight_id());
    if (flightData.size() != 1) {
      return null;
    }
    FlightEntity flightEntity = flightData.get(0);
    BookingEntity bookingEntity = new BookingEntity();
    bookingEntity.setBookingTime(Timestamp.valueOf(LocalDateTime.now()));
    bookingEntity.setFlightId(flightEntity.getFlightId());
    bookingEntity.setReference(reference);
    bookingEntity.setStatus("Book");
    bookingEntity.setTotalPrice(flightEntity.getPrice().multiply(BigDecimal.valueOf(flight.getPnum())));
    bookingEntity.setUserId(userId);
    return bookingRequestRepository.save(bookingEntity);
  };

  @Transactional
  public List<BookingEntity> bookRoundTrip(BookFlightRequestData flight_dep, BookFlightRequestData flight_des,
      Long userId, String reference) {
    List<FlightEntity> flightData = flightsRepository.findByFlightIdOrFlightId(flight_dep.getFlight_id(),
        flight_des.getFlight_id());
    if (flightData.size() != 2) {
      return null;
    }
    List<BookingEntity> bookingEntityList = new ArrayList<BookingEntity>();
    for (FlightEntity flightEntity : flightData) {
      BookingEntity bookingEntity = new BookingEntity();
      bookingEntity.setBookingTime(Timestamp.valueOf(LocalDateTime.now()));
      bookingEntity.setFlightId(flightEntity.getFlightId());
      bookingEntity.setReference(reference);
      bookingEntity.setStatus("Book");
      bookingEntity.setTotalPrice(flightEntity.getPrice().multiply(BigDecimal.valueOf(flight_dep.getPnum())));
      bookingEntity.setUserId(userId);
      bookingEntityList.add(bookingEntity);
    }
    return bookingRequestRepository.saveAll(bookingEntityList);
  };

}
