package com.example.flightapi.dto;

import lombok.Data;

@Data
public class CommonResponseDto<T> {
  private boolean success;

  private int code;

  private String message;

  private T data;

  public CommonResponseDto(boolean success, int code, String message, T data) {
    setSuccess(success);
    setCode(code);
    setMessage(message);
    setData(data);
  }
}
