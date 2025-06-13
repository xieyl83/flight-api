package com.example.flightapi.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.flightapi.dto.FlightDto;
import com.example.flightapi.entity.FlightEntity;

public class FlightMapper {
  public static FlightDto entityToDto(FlightEntity flightEntity) {
    FlightDto flightDto = new FlightDto();
    flightDto.setFlight_id(flightEntity.getFlightId());
    flightDto.setFlight_number(flightEntity.getFlightNumber());
    flightDto.setCompany_id(flightEntity.getCompanyId());
    flightDto.setCompany_name(flightEntity.getNameCn());
    flightDto.setDeparture_airport_id(flightEntity.getDepartureAirportId());
    flightDto.setDestination_airport_id(flightEntity.getDestinationAirportId());
    flightDto.setDeparture_date(flightEntity.getDepartureDate());
    flightDto.setDeparture_time(flightEntity.getDepartureTime());
    flightDto.setDestination_date(flightEntity.getDestinationDate());
    flightDto.setDestination_time(flightEntity.getDestinationTime());
    flightDto.setStop_over(flightEntity.getStopOver());
    flightDto.setPrice(flightEntity.getPrice());
    flightDto.setDep_code(flightEntity.getDepCode());
    flightDto.setDep_name(flightEntity.getDepName());
    flightDto.setDep_city(flightEntity.getDesCity());
    flightDto.setDes_code(flightEntity.getDesCode());
    flightDto.setDes_name(flightEntity.getDesName());
    flightDto.setDes_city(flightEntity.getDesCity());
    return flightDto;
  }

  public static List<FlightDto> entityListToDto(List<FlightEntity> flightEntityList) {
    List<FlightDto> flightDtoList = new ArrayList<FlightDto>();
    flightEntityList.forEach(flightEntity -> flightDtoList.add(entityToDto(flightEntity)));
    return flightDtoList;
  }
}
