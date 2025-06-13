package com.example.flightapi.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BookingData {
  private Long booking_id;

  private Long user_id;

  private Long flight_id;

  private String reference;

  private String status;

  private Timestamp booking_time;

  private BigDecimal total_price;
}
