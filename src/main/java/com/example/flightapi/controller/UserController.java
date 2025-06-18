package com.example.flightapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.dto.CommonResponseDto;
import com.example.flightapi.dto.UserInfoDto;
import com.example.flightapi.dto.UserRequestDto;
import com.example.flightapi.entity.UserEntity;
import com.example.flightapi.mapper.UserInfoMapper;
import com.example.flightapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  @CrossOrigin(origins = "*")
  @PostMapping("/create")
  public CommonResponseDto<Boolean> createUser(@RequestBody UserRequestDto requestData) {
    CommonResponseDto<Boolean> response = new CommonResponseDto<Boolean>(false, 200, "", Boolean.FALSE);

    UserEntity userEntity = userService.findUserByEmail(requestData.getEmail());
    if (userEntity != null) {
      response.setMessage("该账户已被注册。");
      return response;
    }

    UserInfoDto userInfoDto = userService.createUser(UserInfoMapper.requestToDto(requestData));
    if (userInfoDto == null) {
      response.setMessage("账户创建失败，请稍后重试。");
      return response;
    }

    response.setSuccess(true);
    response.setData(Boolean.TRUE);
    return response;
  }

}
