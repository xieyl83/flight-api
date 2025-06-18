package com.example.flightapi.util;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.flightapi.dto.UserInfoDto;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenUtil {
  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private Long expiration;

  private SecretKey secretKey;

  @PostConstruct
  private void init() {
    secretKey = Keys.hmacShaKeyFor(secret.getBytes());
  }

  @SuppressWarnings("deprecation")
  public String genToken(UserInfoDto userInfo) {
    JwtBuilder jwtBuilder = Jwts.builder();
    jwtBuilder.id(userInfo.getUserId().toString());
    jwtBuilder.subject(userInfo.getEmail());
    jwtBuilder.claim("userInfo", userInfo);
    jwtBuilder.issuedAt(new Date());
    jwtBuilder.expiration(new Date(System.currentTimeMillis() + expiration));
    jwtBuilder.signWith(secretKey, SignatureAlgorithm.HS256);
    return jwtBuilder.compact();
  }

  public boolean validateToken(UserInfoDto extractedUserInfo, UserDetails userDetails) {
    if (extractedUserInfo == null || userDetails == null) {
      return false;
    }
    try {
      return extractedUserInfo.getEmail().equals(userDetails.getUsername());
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public boolean vlidateToken(String token, UserDetails userDetails) {
    try {
      if (userDetails == null) {
        return false;
      }

      JwtParser jwtParser = Jwts.parser().verifyWith(secretKey).build();
      boolean expired = jwtParser.parseSignedClaims(token).getPayload().getExpiration().before(new Date());
      if (expired) {
        return false;
      }

      UserInfoDto parsedUserInfo = claimsToUserInfo(jwtParser.parseSignedClaims(token).getPayload().get("userInfo"));
      return parsedUserInfo.getEmail().equals(userDetails.getUsername());
    } catch (JwtException | IllegalArgumentException e) {
      e.printStackTrace();
      return false;
    }
  }

  private UserInfoDto claimsToUserInfo(Object claims) {
    @SuppressWarnings("rawtypes")
    Map claimsMap = (Map) claims;
    UserInfoDto userInfo = new UserInfoDto();
    if (claimsMap.containsKey("userId")) {
      userInfo.setUserId(Long.valueOf(claimsMap.get("userId").toString()));
    }
    if (claimsMap.containsKey("country")) {
      userInfo.setCountry(claimsMap.get("country").toString());
    }
    if (claimsMap.containsKey("email")) {
      userInfo.setEmail(claimsMap.get("email").toString());
    }
    if (claimsMap.containsKey("firstName")) {
      userInfo.setFirstName(claimsMap.get("firstName").toString());
    }
    if (claimsMap.containsKey("lastName")) {
      userInfo.setLastName(claimsMap.get("lastName").toString());
    }
    if (claimsMap.containsKey("phone")) {
      userInfo.setPhone(claimsMap.get("phone").toString());
    }
    return userInfo;
  }

  public boolean isExpired(String token) {
    try {
      JwtParser jwtParser = Jwts.parser().verifyWith(secretKey).build();
      return jwtParser.parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    } catch (JwtException | IllegalArgumentException e) {
      e.printStackTrace();
      return false;
    }
  }

  public UserInfoDto extractUserInfo(String token) {
    try {
      JwtParser jwtParser = Jwts.parser().verifyWith(secretKey).build();
      UserInfoDto parsedUserInfo = claimsToUserInfo(jwtParser.parseSignedClaims(token).getPayload().get("userInfo"));
      return parsedUserInfo;
    } catch (JwtException | IllegalArgumentException e) {
      e.printStackTrace();
      return null;
    }

  }
}
