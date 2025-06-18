package com.example.flightapi.dto;

import lombok.Data;

@Data
public class UserRequestDto {

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private String phone;

  private String country;

}
