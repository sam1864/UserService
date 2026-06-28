package com.bookmycar.bookmycar.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class CarBookingRequest {

    private String carName;

    private String regNo;

    private Long userId;

    private Long carId;

    private double advanceAmount;

    private LocalDateTime carReturnDate;

    private LocalDateTime carBookingStartDate;
}
