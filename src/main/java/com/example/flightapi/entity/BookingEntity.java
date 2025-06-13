package com.example.flightapi.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class BookingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "booking_id")
  private Long bookingId;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "flight_id")
  private Long flightId;

  @Column(name = "reference")
  private String reference;

  @Column(name = "status")
  private String status;

  @Column(name = "booking_time")
  private Timestamp bookingTime;

  @Column(name = "total_price", precision = 38, scale = 2)
  private BigDecimal totalPrice;

}
