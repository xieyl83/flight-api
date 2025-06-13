package com.example.flightapi.entity;

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
public class FlightEntity {
  @Id
  @Column(name = "flight_id")
  private Long flightId;

  @Column(name = "flight_number")
  private String flightNumber;

  @Column(name = "company_id")
  private String companyId;

  @Column(name = "departure_airport_id")
  private Long departureAirportId;

  @Column(name = "destination_airport_id")
  private Long destinationAirportId;

  @Column(name = "departure_date")
  @Temporal(TemporalType.DATE)
  private Date departureDate;

  @Column(name = "departure_time")
  @Temporal(TemporalType.TIME)
  private Time departureTime;

  @Column(name = "destination_date")
  @Temporal(TemporalType.DATE)
  private Date destinationDate;

  @Column(name = "destination_time")
  @Temporal(TemporalType.TIME)
  private Time destinationTime;

  @Column(name = "stop_over")
  private String stopOver;

  @Column(name = "price", precision = 10, scale = 2)
  private BigDecimal price;

  @Column(name = "dep_code")
  private String depCode;

  @Column(name = "dep_name")
  private String depName;

  @Column(name = "dep_city")
  private String depCity;

  @Column(name = "des_code")
  private String desCode;

  @Column(name = "des_name")
  private String desName;

  @Column(name = "des_city")
  private String desCity;

  @Column(name = "name_en")
  private String nameEn;

  @Column(name = "name_cn")
  private String nameCn;

}
