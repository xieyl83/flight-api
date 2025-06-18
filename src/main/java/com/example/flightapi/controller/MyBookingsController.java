package com.example.flightapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.dto.CommonResponseDto;
import com.example.flightapi.dto.MyBookingDto;
import com.example.flightapi.dto.MyBookingsRequestDto;
import com.example.flightapi.entity.BookingViewEntity;
import com.example.flightapi.mapper.MyBookingsMapper;
import com.example.flightapi.service.BookingViewService;
import com.example.flightapi.service.UserService;

@RestController
@RequestMapping("/api/mybookings")
public class MyBookingsController {
  @Autowired
  BookingViewService bookingViewService;

  @Autowired
  UserService userService;

  @CrossOrigin(origins = "*")
  @PostMapping
  public CommonResponseDto<List<MyBookingDto>> getMyBookings(@RequestBody MyBookingsRequestDto requestData,
      Authentication authentication) {
    CommonResponseDto<List<MyBookingDto>> response = null;

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    Long user_id = userService.findUserByEmail(userDetails.getUsername()).getUserId();

    // to do: paging, sort...

    List<BookingViewEntity> queryResuts = bookingViewService.queryBookingsForUser(user_id);
    if (queryResuts == null || queryResuts.size() < 1) {
      response = new CommonResponseDto<List<MyBookingDto>>(false, 200, "没有订票数据。",
          null);
      return response;
    }
    response = new CommonResponseDto<List<MyBookingDto>>(true, 200, "OK",
        MyBookingsMapper.entityListToDto(queryResuts));
    return response;
  }
}
