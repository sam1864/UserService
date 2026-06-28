package com.bookmycar.bookmycar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "car_details",schema = "cars")
@Getter
@Setter
public class CarDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @Column(name="car_name")
    private String carName;

    @Column(name = "reg_no")
    private String regNo;

    @Column(name="model")
    private int model;

    @Column(name="insurance_number")
    private String insuranceNo;

    @Column(name="insurance_due")
    private LocalDate insuranceDueDate;

    @Column(name="lastServiceDate")
    private LocalDate lastServiceDate;

    @Column(name="is_all_doc_ok")
    private boolean isAllDocOK;

    @Column(name="price_per_hour")
    private Double pricePerHour;

    @Column(name="is_available")
    private boolean isAvailable;


}
