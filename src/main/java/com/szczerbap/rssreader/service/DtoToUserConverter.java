package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.dto.UserRegistrationDto;
import com.szczerbap.rssreader.model.User;
import org.springframework.stereotype.Service;


@Service
public class DtoToUserConverter implements BaseConverter<UserRegistrationDto,User>{


    @Override
    public User convert(UserRegistrationDto from) {

        User user=new User();

        user.setUserName(from.getUserName());
        user.setEmail(from.getEmail());
        user.setPassword(from.getPassword());

        return user;
    }
}
