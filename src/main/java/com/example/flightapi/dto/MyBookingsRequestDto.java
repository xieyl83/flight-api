package com.example.flightapi.dto;

import lombok.Data;

@Data
public class MyBookingsRequestDto {
  private Integer page_number;

  private Integer page_limit;

  private String sort_col;

  private String sort_type;
}
