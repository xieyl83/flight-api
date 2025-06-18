package com.example.flightapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightapi.entity.BookingViewEntity;
import com.example.flightapi.repository.BookingViewRepository;
import com.example.flightapi.service.BookingViewService;

@Service
public class BookingViewServiceImpl implements BookingViewService {

  @Autowired
  private BookingViewRepository bookingViewRepository;

  @Override
  public List<BookingViewEntity> queryBookingsForUser(Long user_id) {
    return bookingViewRepository.findByUserId(user_id);
  }

}
