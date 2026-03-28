package com.bookmycar.bookmycar.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoRequest {

    private String name;

    private String contact;

    private String email;

    private String password;

}
