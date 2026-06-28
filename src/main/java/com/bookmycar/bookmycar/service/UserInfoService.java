package com.bookmycar.bookmycar.service;

import com.bookmycar.bookmycar.exception.IncorrectPasswordException;
import com.bookmycar.bookmycar.request.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {

    void createUser(com.bookmycar.bookmycar.request.UserInfoRequest userInfo) throws Exception;

    void loginUser(LoginRequest loginRequest) throws Exception;
}
