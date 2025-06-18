package com.example.flightapi.service;

import java.util.List;

import com.example.flightapi.entity.BookingViewEntity;

public interface BookingViewService {

  public List<BookingViewEntity> queryBookingsForUser(Long user_id);
}
