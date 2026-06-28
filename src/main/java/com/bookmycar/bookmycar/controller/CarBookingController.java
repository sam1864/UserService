package com.bookmycar.bookmycar.controller;

import com.bookmycar.bookmycar.request.CarBookingRequest;
import com.bookmycar.bookmycar.service.CarBookingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class CarBookingController {

    private CarBookingService carBookingService;

    @PostMapping("/bookcar")
    public ResponseEntity<String> bookCar(@RequestBody CarBookingRequest request){

        try{
            log.info("Car booking started");
            ;
            return ResponseEntity.ok(carBookingService.bookCar(request));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
