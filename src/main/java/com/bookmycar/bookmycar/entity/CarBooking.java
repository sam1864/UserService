package com.bookmycar.bookmycar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "car_bookings", schema = "cars")
@Getter
@Setter
public class CarBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="car_id",nullable = false)
    private CarDetailsEntity cars;

    @Column(name = "advance_amount")
    private double advanceAmount;

    @Column(name="creation_date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name="modification_date")
    @UpdateTimestamp
    private LocalDateTime modificationDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;


    @Column(name="booking_time",nullable = false)
    private LocalDateTime bookingTime;

    @Column(name ="pending_amount",nullable = false)
    private double pendingAmount;



}
