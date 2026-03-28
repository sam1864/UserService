package com.bookmycar.bookmycar.service;

import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {

    void createUser(com.bookmycar.bookmycar.request.UserInfoRequest userInfo);
}
