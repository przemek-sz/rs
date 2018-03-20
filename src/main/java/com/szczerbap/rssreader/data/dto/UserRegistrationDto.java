package com.szczerbap.rssreader.data.dto;

import org.springframework.stereotype.Component;


@Component
public class UserRegistrationDto implements UserDto {

    String userName;

    String email;

    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
