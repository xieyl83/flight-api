package com.example.flightapi.dto;

import com.example.flightapi.pojo.BookingData;

import lombok.Data;

@Data
public class BookingResultDto {
  private BookingData flight_dep;

  private BookingData flight_des;

}
