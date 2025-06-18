package com.example.flightapi.service;

import com.example.flightapi.dto.UserInfoDto;
import com.example.flightapi.entity.UserEntity;

public interface UserService {

  public UserEntity findUserByEmail(String email);

  public UserEntity findUserByEmailAndPassword(String email, String password);

  public UserInfoDto createUser(UserInfoDto userInfoDto);

}
