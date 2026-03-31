package com.bookmycar.bookmycar.controller;


import com.bookmycar.bookmycar.serviceImpl.MessageSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final MessageSender sender;

    public TestController(MessageSender sender) {
        this.sender = sender;
    }

    @GetMapping("/send")
    public String sendMessage() {
        sender.send();
        return "Message sent";
    }
}
