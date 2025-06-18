package com.example.flightapi.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserInfoDto implements UserDetails {
  private Long userId;

  private String password;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  private String country;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public String getUsername() {
    return this.email;
  }

}
