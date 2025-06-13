package com.example.flightapi.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class FlightDto {
  private Long flight_id;

  private String flight_number;

  private String company_id;

  private Long departure_airport_id;

  private Long destination_airport_id;

  private Date departure_date;

  private Time departure_time;

  private Date destination_date;

  private Time destination_time;

  private String stop_over;

  private BigDecimal price;

  private String dep_code;

  private String dep_name;

  private String dep_city;

  private String des_code;

  private String des_name;

  private String des_city;

  private String company_name;

}
