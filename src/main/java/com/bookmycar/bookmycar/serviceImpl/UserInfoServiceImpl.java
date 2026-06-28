package com.bookmycar.bookmycar.serviceImpl;

import com.bookmycar.bookmycar.entity.UserInfo;
import com.bookmycar.bookmycar.exception.IncorrectPasswordException;
import com.bookmycar.bookmycar.exception.UserAlreadyExistException;
import com.bookmycar.bookmycar.request.LoginRequest;
import com.bookmycar.bookmycar.request.UserInfoRequest;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements com.bookmycar.bookmycar.service.UserInfoService {

    private final RabbitTemplate rabbitTemplate;

    private final MessageSender messageSender;

private  final com.bookmycar.bookmycar.repository.UserInfoRepository userInfoRepository;
    @Override
    public void createUser(UserInfoRequest userRequest)  throws Exception{
        UserInfo userInfo= userInfoRepository.findByEmail(userRequest.getEmail());

        if(userInfo==null){
            boolean verified = messageSender.sendUserData(userRequest);
            if(verified) {
                UserInfo userInfoModel=new UserInfo();
                userInfoModel.setName(userRequest.getName());
                userInfoModel.setEmail(userRequest.getEmail());
                userInfoModel.setContact(userRequest.getContact());
                userInfoModel.setPassword(userRequest.getPassword());
                userInfoModel.setVerified(true);

                userInfoRepository.save(userInfoModel);
            }else{
                throw new Exception("user data not valid");
            }

        }else{
            throw new UserAlreadyExistException("User already exist");
        }

    }

    @Override
    public void loginUser(LoginRequest loginRequest) throws Exception {
        UserInfo userInfo= userInfoRepository.findByEmail(loginRequest.getEmail());
        if(userInfo!=null){
            if(userInfo.getPassword().equals(loginRequest.getPassword())){
                System.out.println("Welcome......!");
            }
            else{
                throw new IncorrectPasswordException("Password is incorrect.....!!");
            }
        }
        else {
            throw new Exception("User Does not exist");
        }
    }
}
