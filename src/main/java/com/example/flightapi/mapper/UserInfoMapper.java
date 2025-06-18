package com.example.flightapi.mapper;

import com.example.flightapi.dto.UserInfoDto;
import com.example.flightapi.dto.UserRequestDto;
import com.example.flightapi.entity.UserEntity;
import com.example.flightapi.pojo.UserData;

public class UserInfoMapper {
  public static UserInfoDto requestToDto(UserRequestDto requestData) {
    UserInfoDto userInfoDto = new UserInfoDto();
    userInfoDto.setCountry(requestData.getCountry());
    userInfoDto.setEmail(requestData.getEmail());
    userInfoDto.setFirstName(requestData.getFirstName());
    userInfoDto.setLastName(requestData.getLastName());
    userInfoDto.setPassword(requestData.getPassword());
    userInfoDto.setPhone(requestData.getPhone());
    return userInfoDto;
  }

  public static UserInfoDto entityToDto(UserEntity userEntity) {
    UserInfoDto userInfoDto = new UserInfoDto();
    userInfoDto.setUserId(userEntity.getUserId());
    userInfoDto.setEmail(userEntity.getEmail());
    userInfoDto.setPassword(userEntity.getPassword());
    userInfoDto.setFirstName(userEntity.getFirstName());
    userInfoDto.setLastName(userEntity.getLastName());
    userInfoDto.setCountry(userEntity.getCountry());
    userInfoDto.setPhone(userEntity.getPhone());
    return userInfoDto;
  }

  public static UserData entityToData(UserEntity userEntity) {
    UserData userInfoDto = new UserData();
    userInfoDto.setUserId(userEntity.getUserId());
    userInfoDto.setEmail(userEntity.getEmail());
    userInfoDto.setFirstName(userEntity.getFirstName());
    userInfoDto.setLastName(userEntity.getLastName());
    userInfoDto.setCountry(userEntity.getCountry());
    userInfoDto.setPhone(userEntity.getPhone());
    return userInfoDto;
  }

  public static UserEntity dtoToEntity(UserInfoDto userInfoDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUserId(userInfoDto.getUserId());
    userEntity.setEmail(userInfoDto.getEmail());
    userEntity.setPassword(userInfoDto.getPassword());
    userEntity.setFirstName(userInfoDto.getFirstName());
    userEntity.setLastName(userInfoDto.getLastName());
    userEntity.setCountry(userInfoDto.getCountry());
    userEntity.setPhone(userInfoDto.getPhone());
    return userEntity;
  }
}
