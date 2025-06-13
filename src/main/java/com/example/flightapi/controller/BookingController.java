package com.example.flightapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightapi.dto.BookingRequestDto;
import com.example.flightapi.dto.BookingResultDto;
import com.example.flightapi.dto.CommonResponseDto;
import com.example.flightapi.entity.BookingEntity;
import com.example.flightapi.mapper.BookingMapper;
import com.example.flightapi.pojo.BookFlightRequestData;
import com.example.flightapi.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
  @Autowired
  private BookingService bookingService;

  @PostMapping
  public CommonResponseDto<BookingResultDto> bookFlights(@RequestBody BookingRequestDto requestData) {
    CommonResponseDto<BookingResultDto> response = null;
    List<BookFlightRequestData> flightsData = requestData.getFlights();
    List<BookingEntity> bookingEntityList = new ArrayList<BookingEntity>();
    if (flightsData.size() == 1) {
      BookingEntity bookingEntity = bookingService.bookSingleTrip(flightsData.get(0), 1L, "单程");
      if (bookingEntity == null) {
        response = new CommonResponseDto<BookingResultDto>(false, 200, "订票信息登记失败，请稍后重试。",
            null);
        return response;
      }
      bookingEntityList.add(bookingEntity);
    } else if (flightsData.size() == 2) {
      List<BookingEntity> results = bookingService.bookRoundTrip(flightsData.get(0), flightsData.get(1), 1L, "往返");
      if (results.size() != 2) {
        response = new CommonResponseDto<BookingResultDto>(false, 200, "订票信息登记失败，请稍后重试。",
            null);
        return response;
      }
      bookingEntityList.addAll(results);
    } else {
      response = new CommonResponseDto<BookingResultDto>(false, 200, "订票信息错误，请稍后重试。",
          null);
      return response;
    }
    Long flight_id_dep = flightsData.get(0).getFlight_id();
    Long flight_id_des = null;
    if (flightsData.size() == 2) {
      flight_id_des = flightsData.get(1).getFlight_id();
    }
    BookingResultDto resultDto = BookingMapper.entityToDto(bookingEntityList,
        flight_id_dep, flight_id_des);
    response = new CommonResponseDto<BookingResultDto>(true, 200, "OK", resultDto);
    return response;
  }

}
