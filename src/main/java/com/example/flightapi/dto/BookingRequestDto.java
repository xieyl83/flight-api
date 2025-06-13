package com.example.flightapi.dto;

import java.util.List;

import com.example.flightapi.pojo.BookFlightRequestData;

import lombok.Data;

@Data
public class BookingRequestDto {
  private List<BookFlightRequestData> flights;
}
