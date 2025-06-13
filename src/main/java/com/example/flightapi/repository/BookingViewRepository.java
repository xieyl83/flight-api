package com.example.flightapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightapi.entity.BookingViewEntity;
import java.util.List;

public interface BookingViewRepository extends JpaRepository<BookingViewEntity, Long> {
  List<BookingViewEntity> findByUserId(Long userId);
}
