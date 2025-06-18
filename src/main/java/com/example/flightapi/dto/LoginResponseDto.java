package com.example.flightapi.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
  private Long userId;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  private String country;

  private String token;
}
