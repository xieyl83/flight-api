package com.example.flightapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.dto.CommonResponseDto;
import com.example.flightapi.dto.FlightDto;
import com.example.flightapi.entity.FlightEntity;
import com.example.flightapi.mapper.FlightMapper;
import com.example.flightapi.service.FlightsService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
  @Autowired
  private FlightsService flightsService;

  @GetMapping
  public CommonResponseDto<List<FlightDto>> getFlights(@RequestParam("dep") String dep_city,
      @RequestParam("des") String des_city,
      @RequestParam String depDate) {
    // todo: validate input

    SimpleDateFormat baseSdf = new SimpleDateFormat("yyyy-MM-dd");
    Date departureDate = null;
    CommonResponseDto<List<FlightDto>> response = null;
    try {
      departureDate = new Date(baseSdf.parse(depDate).getTime());
    } catch (ParseException e) {
      e.printStackTrace();
      response = new CommonResponseDto<List<FlightDto>>(
          false,
          500,
          "系统错误，请稍后再试。", // will not send error details to front-end for security
          null);
      return response;
    }
    List<FlightEntity> flightEntityList = flightsService.queryFlights(dep_city, des_city, departureDate);
    if (flightEntityList == null || flightEntityList.isEmpty()) {
      response = new CommonResponseDto<List<FlightDto>>(false, 200, "没有指定条件的航班。", null);
      return response;
    }
    List<FlightDto> flightDto = FlightMapper.entityListToDto(flightEntityList);
    response = new CommonResponseDto<List<FlightDto>>(true, 200, "OK", flightDto);
    return response;
  }

}
