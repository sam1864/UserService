package com.bookmycar.bookmycar.serviceImpl;

import com.bookmycar.bookmycar.entity.UserInfo;
import com.bookmycar.bookmycar.exception.UserAlreadyExistException;
import com.bookmycar.bookmycar.request.UserInfoRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements com.bookmycar.bookmycar.service.UserInfoService {

private  final com.bookmycar.bookmycar.repository.UserInfoRepository userInfoRepository;
    @Override
    public void createUser(UserInfoRequest userRequest) {

        if(userInfoRepository.findByEmail(userRequest.getEmail())==null){
            UserInfo userInfo = new UserInfo();
            userInfo.setName(userRequest.getName());
            userInfo.setEmail(userRequest.getEmail());
            userInfo.setContact(userRequest.getContact());
            userInfo.setPassword(userRequest.getPassword());

            userInfoRepository.save(userInfo);

        }else{
            throw new UserAlreadyExistException("User already exist");
        }

    }
}
