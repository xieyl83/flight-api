package com.example.flightapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.flightapi.service.BookingService;
import com.example.flightapi.service.UserService;
import com.example.flightapi.service.impl.BookingServiceImpl;
import com.example.flightapi.service.impl.UserServiceImpl;

@Configuration
public class AppConfig {

  @Bean
  public BookingService bookingService() {
    return new BookingServiceImpl();
  }

  @Bean
  UserService userService() {
    return new UserServiceImpl();
  }

}
