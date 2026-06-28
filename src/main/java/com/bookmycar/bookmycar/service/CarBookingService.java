package com.bookmycar.bookmycar.service;

import com.bookmycar.bookmycar.request.CarBookingRequest;
import org.springframework.stereotype.Service;

@Service
public interface CarBookingService {

    public String bookCar(CarBookingRequest request);
}
