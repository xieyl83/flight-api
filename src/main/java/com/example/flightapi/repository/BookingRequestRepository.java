package com.example.flightapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightapi.entity.BookingEntity;

@Repository
public interface BookingRequestRepository extends JpaRepository<BookingEntity, Long> {
}
