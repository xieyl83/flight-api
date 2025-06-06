package com.example.flightApi.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "v_flight")
public class Flights {
  @Id
  @Column(name = "flight_id")
  private Long flight_id;

  @Column(name = "flight_number")
  private String flight_number;

  @Column(name = "company_id")
  private String company_id;

  @Column(name = "departure_airport_id")
  private Long departure_airport_id;

  @Column(name = "destination_airport_id")
  private Long destination_airport_id;

  @Column(name = "departure_date")
  @Temporal(TemporalType.DATE)
  private Date departure_date;

  @Column(name = "departure_time")
  @Temporal(TemporalType.TIME)
  private Time departure_time;

  @Column(name = "destination_date")
  @Temporal(TemporalType.DATE)
  private Date destination_date;

  @Column(name = "destination_time")
  @Temporal(TemporalType.TIME)
  private Time destination_time;

  @Column(name = "stop_over")
  private String stop_over;

  @Column(name = "price", precision = 10, scale = 2)
  private BigDecimal price;

  @Column(name = "dep_code")
  private String dep_code;

  @Column(name = "dep_name")
  private String dep_name;

  @Column(name = "dep_city")
  private String dep_city;

  @Column(name = "des_code")
  private String des_code;

  @Column(name = "des_name")
  private String des_name;

  @Column(name = "des_city")
  private String des_city;

  @Column(name = "name_en")
  private String name_en;

  @Column(name = "name_cn")
  private String name_cn;

}
