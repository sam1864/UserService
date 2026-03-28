package com.bookmycar.bookmycar.controller;


import com.bookmycar.bookmycar.request.UserInfoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final com.bookmycar.bookmycar.service.UserInfoService userInfoService;

    public UserController(com.bookmycar.bookmycar.service.UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/createUsers")
    public ResponseEntity<String> createUser(@RequestBody UserInfoRequest userInfo){
        try {
            userInfoService.createUser(userInfo);
            return ResponseEntity.ok("User created");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating user: " + e.getMessage());
        }
    }
}
