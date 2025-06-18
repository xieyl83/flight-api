package com.example.flightapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.flightapi.dto.UserInfoDto;
import com.example.flightapi.entity.UserEntity;
import com.example.flightapi.mapper.UserInfoMapper;
import com.example.flightapi.repository.UserRepository;
import com.example.flightapi.service.UserService;

import jakarta.transaction.Transactional;

public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserEntity findUserByEmail(String email) {
    Optional<UserEntity> userEntityOpt = userRepository.findByEmail(email);
    if (userEntityOpt.isPresent()) {
      return userEntityOpt.get();
    }
    return null;
  }

  @Override
  public UserEntity findUserByEmailAndPassword(String email, String password) {
    Optional<UserEntity> userEntityOpt = userRepository.findByEmailAndPassword(email, password);
    if (userEntityOpt.isPresent()) {
      return userEntityOpt.get();
    }
    return null;
  }

  @Override
  @Transactional
  public UserInfoDto createUser(UserInfoDto userInfoDto) {
    userInfoDto.setUserId(null);
    UserEntity userEntity = userRepository.save(UserInfoMapper.dtoToEntity(userInfoDto));
    return UserInfoMapper.entityToDto(userEntity);
  }

}
