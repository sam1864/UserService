package com.bookmycar.bookmycar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyCarApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookMyCarApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=================================");
        System.out.println("   CAR RENTAL MANAGEMENT CLIENT  ");
        System.out.println("=================================");
    }

    while()

}
