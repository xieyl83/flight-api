package com.example.flightapi.mapper;

import com.example.flightapi.dto.LoginResponseDto;
import com.example.flightapi.entity.UserEntity;

public class LoginResponseMapper {

  public static LoginResponseDto entityToDto(UserEntity userEntity, String token) {
    LoginResponseDto loginResponseDto = new LoginResponseDto();
    loginResponseDto.setCountry(userEntity.getCountry());
    loginResponseDto.setEmail(userEntity.getEmail());
    loginResponseDto.setFirstName(userEntity.getFirstName());
    loginResponseDto.setLastName(userEntity.getLastName());
    loginResponseDto.setPhone(userEntity.getPhone());
    loginResponseDto.setToken(token);
    loginResponseDto.setUserId(userEntity.getUserId());
    return loginResponseDto;
  };

}
