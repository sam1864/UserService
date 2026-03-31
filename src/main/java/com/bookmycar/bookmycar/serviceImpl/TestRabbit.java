package com.bookmycar.bookmycar.serviceImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TestRabbit {

    private final RabbitTemplate rabbitTemplate;

    public TestRabbit(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void test() {
        System.out.println("RabbitTemplate loaded: " + rabbitTemplate);
    }
}
