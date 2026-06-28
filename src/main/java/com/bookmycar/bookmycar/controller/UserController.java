package com.bookmycar.bookmycar.controller;


import com.bookmycar.bookmycar.exception.IncorrectPasswordException;
import com.bookmycar.bookmycar.request.LoginRequest;
import com.bookmycar.bookmycar.request.UserInfoRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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

    @PostMapping("/signIn")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request){
        try{
            userInfoService.loginUser(loginRequest);
            HttpSession session= request.getSession(true);
            session.setAttribute("LOGGED_IN_USER",loginRequest.getEmail());
            log.info("Session saved for user {}" ,session.getAttribute("LOGGED_IN_USER"));
            return ResponseEntity.ok("Successfully logged in....!");
        } catch (IncorrectPasswordException e) {
            return ResponseEntity.status(500).body("Error "+e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error"+e.getMessage());
        }
    }
}
