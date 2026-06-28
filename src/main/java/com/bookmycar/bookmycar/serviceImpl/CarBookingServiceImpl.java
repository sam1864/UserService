package com.bookmycar.bookmycar.serviceImpl;

import com.bookmycar.bookmycar.entity.CarBooking;
import com.bookmycar.bookmycar.entity.CarDetailsEntity;
import com.bookmycar.bookmycar.entity.UserInfo;
import com.bookmycar.bookmycar.exception.CarNotAvailableException;
import com.bookmycar.bookmycar.repository.CarBookingRepository;
import com.bookmycar.bookmycar.repository.CarInfoRepository;
import com.bookmycar.bookmycar.repository.UserInfoRepository;
import com.bookmycar.bookmycar.request.CarBookingRequest;
import com.bookmycar.bookmycar.service.CarBookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CarBookingServiceImpl implements CarBookingService {

    private CarInfoRepository carInfoRepository;

  //  private CarDetailsEntity carDetailsEntity;

    private CarBookingRepository carBookingRepository;

    private UserInfoRepository userInfoRepository;

    @Override
    public String bookCar(CarBookingRequest request) {
        try{
            CarDetailsEntity carDetailsEntity= carInfoRepository.findByCarNameAndRegNoAndIsAvailableTrue(request.getCarName().toUpperCase(), request.getRegNo().toUpperCase());
            Optional<UserInfo> userInfo = userInfoRepository.findById(request.getUserId());
            if(Objects.isNull(carDetailsEntity)){
              //  throw new CarNotAvailableException("Sorry car is not available at this time");

                return "Sorry car is not available at this time";
            }
            else{
                CarBooking carBooking= new CarBooking();
                double pendingAmount = calculatePendingAmount(request,carDetailsEntity.getPricePerHour());
                carBooking.setCars(carDetailsEntity);
                carBooking.setUser(userInfo.get());
                carBooking.setBookingTime(request.getCarBookingStartDate());
                carBooking.setReturnDate(request.getCarReturnDate());
                carBooking.setAdvanceAmount(request.getAdvanceAmount());
                carBooking.setPendingAmount(pendingAmount);

                carBookingRepository.save(carBooking);
                //retrun ("Car successfully Booked and your pending amount is {}",pendingAmount);

                return "Car successfully Booked and your pending amount is :"+pendingAmount;



            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private double calculatePendingAmount(CarBookingRequest request, double pricePerHour) {
        LocalDateTime bookingTime = request.getCarBookingStartDate();
        LocalDateTime returnTime = request.getCarReturnDate();

        // 1. Get the raw seconds (long is fine here because seconds are whole numbers)
        long bookingSeconds = bookingTime.toEpochSecond(ZoneOffset.UTC);
        long returnSeconds = returnTime.toEpochSecond(ZoneOffset.UTC);

        long totalSecondsElapsed = returnSeconds - bookingSeconds;

        // 2. FORCE the math to use double by dividing by 3600.0 (not 3600)
        // This preserves the decimal points (e.g., 9000 seconds / 3600.0 = 2.5 hours)
        double totalNoOfHours = totalSecondsElapsed / 3600.0;

        // 3. Return the total amount
        return (totalNoOfHours * pricePerHour)-request.getAdvanceAmount();
    }
}
