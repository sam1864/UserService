package com.bookmycar.bookmycar.repository;

import com.bookmycar.bookmycar.entity.CarBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBookingRepository extends JpaRepository<CarBooking, Long> {
}
