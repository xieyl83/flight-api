package com.example.flightapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightapi.entity.BookingViewEntity;
import com.example.flightapi.repository.BookingViewRepository;

@Service
public class BookingViewService {
  @Autowired
  private BookingViewRepository bookingViewRepository;

  public List<BookingViewEntity> queryBookingsForUser(Long user_id) {
    return bookingViewRepository.findByUserId(user_id);
  }
}
