package com.szczerbap.rssreader.service;

import com.szczerbap.rssreader.data.dto.AllUserDto;
import com.szczerbap.rssreader.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserToDtoConverter implements BaseConverter<User, AllUserDto> {

    @Override
    public AllUserDto convert(User from) {

        AllUserDto userDto= new AllUserDto();
        userDto.setId(from.getId());
        userDto.setUserName(from.getUserName());
        userDto.setEmail(from.getEmail());

        return userDto;
    }
}
