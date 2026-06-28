package com.bookmycar.bookmycar.repository;


import com.bookmycar.bookmycar.entity.CarDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepository extends JpaRepository<CarDetailsEntity,Long> {

    public CarDetailsEntity findByCarNameAndRegNoAndIsAvailableTrue(String carName,String regNo);
}
