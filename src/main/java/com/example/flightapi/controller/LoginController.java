package com.example.flightapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.dto.CommonResponseDto;
import com.example.flightapi.dto.LoginRequestDto;
import com.example.flightapi.dto.LoginResponseDto;
import com.example.flightapi.entity.UserEntity;
import com.example.flightapi.mapper.LoginResponseMapper;
import com.example.flightapi.mapper.UserInfoMapper;
import com.example.flightapi.service.UserService;
import com.example.flightapi.util.JwtTokenUtil;;

@RestController
@RequestMapping("/api/login")
public class LoginController {

  @Autowired
  UserService userService;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenUtil jwtTokenUtil;

  @CrossOrigin(origins = "*")
  @PostMapping
  public CommonResponseDto<LoginResponseDto> postLogin(@RequestBody LoginRequestDto requestData) {
    CommonResponseDto<LoginResponseDto> response = new CommonResponseDto<LoginResponseDto>(false,
        200,
        "账户或密码错误，登陆失败。",
        null);
    if (!StringUtils.hasText(requestData.getEmail()) || !StringUtils.hasText(requestData.getPassword())) {
      return response;
    }

    UserEntity userEntity = userService.findUserByEmailAndPassword(requestData.getEmail(), requestData.getPassword());
    if (userEntity == null) {
      return response;
    }

    String token = jwtTokenUtil.genToken(UserInfoMapper.entityToDto(userEntity));
    LoginResponseDto loginResponseDto = LoginResponseMapper.entityToDto(userEntity, token);
    response.setSuccess(true);
    response.setMessage("");
    response.setData(loginResponseDto);
    return response;
  }

}
