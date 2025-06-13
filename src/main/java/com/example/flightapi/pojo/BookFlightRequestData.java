package com.example.flightapi.pojo;

import lombok.Data;

@Data
public class BookFlightRequestData {
  /** Flight ID */
  private Long flight_id;

  /** Passenger number */
  private Integer pnum;
}
