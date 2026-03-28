package com.bookmycar.bookmycar.repository;

import com.bookmycar.bookmycar.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByEmail(String email);
}
