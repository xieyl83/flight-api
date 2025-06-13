package com.example.flightapi.mapper;

import java.util.List;

import com.example.flightapi.dto.BookingResultDto;
import com.example.flightapi.entity.BookingEntity;
import com.example.flightapi.pojo.BookingData;

public class BookingMapper {
  public static BookingResultDto entityToDto(List<BookingEntity> bookingEntityList, Long flight_id_dep,
      Long flight_id_des) {
    BookingResultDto bookingResultDto = new BookingResultDto();
    for (int i = 0; i < bookingEntityList.size(); i++) {
      if (i > 1) {
        break;
      }
      BookingEntity bookingEntity = bookingEntityList.get(i);
      BookingData bookingData = new BookingData();
      bookingData.setBooking_id(bookingEntity.getBookingId());
      bookingData.setBooking_time(bookingEntity.getBookingTime());
      bookingData.setFlight_id(bookingEntity.getFlightId());
      bookingData.setReference(bookingEntity.getReference());
      bookingData.setStatus(bookingEntity.getStatus());
      bookingData.setTotal_price(bookingEntity.getTotalPrice());
      bookingData.setUser_id(bookingEntity.getUserId());
      if (bookingData.getFlight_id().equals(flight_id_dep)) {
        bookingResultDto.setFlight_dep(bookingData);
      } else if (bookingData.getFlight_id().equals(flight_id_des)) {
        bookingResultDto.setFlight_des(bookingData);
      }
    }
    return bookingResultDto;
  }
}
