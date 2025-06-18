package com.example.flightapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.flightapi.entity.UserEntity;
import com.example.flightapi.mapper.UserInfoMapper;
import com.example.flightapi.dto.UserInfoDto;
import com.example.flightapi.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserInfoDto loadUserByUsername(String username)
      throws UsernameNotFoundException {
    Optional<UserEntity> userEntityOpt = null;
    try {
      userEntityOpt = userRepository.findByEmail(username);
    } catch (NumberFormatException e) {
      throw new UsernameNotFoundException("用户不存在");
    }
    if (userEntityOpt.isEmpty()) {
      throw new UsernameNotFoundException("用户不存在");
    }
    return UserInfoMapper.entityToDto(userEntityOpt.get());
  }

}
