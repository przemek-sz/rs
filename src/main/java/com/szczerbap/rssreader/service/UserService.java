package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.dto.AllUserDto;
import com.szczerbap.rssreader.data.dto.UserRegistrationDto;
import com.szczerbap.rssreader.model.User;

import java.util.List;


public interface UserService {

    public void addUser(UserRegistrationDto user);
    public void updateUser(User user);
    public void removeUser(User user);
    public List<AllUserDto> getAllUsers();
    public User getByUserName(String username);
}
