package com.szczerbap.rssreader.data.dto;

import org.springframework.stereotype.Component;


@Component
public class AllUserDto implements UserDto {

    private Long id;
    private String userName;
    private String email;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
