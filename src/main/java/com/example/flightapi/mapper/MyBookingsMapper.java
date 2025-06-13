package com.example.flightapi.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.flightapi.dto.MyBookingDto;
import com.example.flightapi.entity.BookingViewEntity;

public class MyBookingsMapper {
  public static MyBookingDto entityToDto(BookingViewEntity bookingEntity) {
    MyBookingDto myBookingDto = new MyBookingDto();
    myBookingDto.setBooking_id(bookingEntity.getBookingId());
    myBookingDto.setBooking_time(bookingEntity.getBookingTime());
    myBookingDto.setCompany_id(bookingEntity.getCompanyId());
    myBookingDto.setCompany_name(bookingEntity.getNameCn());
    myBookingDto.setDep_city(bookingEntity.getDepCity());
    myBookingDto.setDep_code(bookingEntity.getDepCode());
    myBookingDto.setDep_name(bookingEntity.getDepName());
    myBookingDto.setDeparture_airport_id(bookingEntity.getDepartureAirportId());
    myBookingDto.setDeparture_date(bookingEntity.getDepartureDate());
    myBookingDto.setDeparture_time(bookingEntity.getDepartureTime());
    myBookingDto.setDes_city(bookingEntity.getDesCity());
    myBookingDto.setDes_code(bookingEntity.getDesCode());
    myBookingDto.setDes_name(bookingEntity.getDesName());
    myBookingDto.setDestination_airport_id(bookingEntity.getDestinationAirportId());
    myBookingDto.setDestination_date(bookingEntity.getDestinationDate());
    myBookingDto.setDestination_time(bookingEntity.getDestinationTime());
    myBookingDto.setFlight_id(bookingEntity.getFlightId());
    myBookingDto.setFlight_number(bookingEntity.getFlightNumber());
    myBookingDto.setPrice(bookingEntity.getPrice());
    myBookingDto.setReference(bookingEntity.getReference());
    myBookingDto.setStatus(bookingEntity.getStatus());
    myBookingDto.setStop_over(bookingEntity.getStopOver());
    myBookingDto.setTotal_price(bookingEntity.getTotalPrice());
    return myBookingDto;
  }

  public static List<MyBookingDto> entityListToDto(List<BookingViewEntity> bookingEntityList) {
    List<MyBookingDto> myBookingList = new ArrayList<MyBookingDto>();
    bookingEntityList.forEach(bookingViewEntity -> myBookingList.add(entityToDto(bookingViewEntity)));
    return myBookingList;
  }
}
