package com.szczerbap.rssreader.controller;

import com.szczerbap.rssreader.data.dto.AllUserDto;
import com.szczerbap.rssreader.data.dto.UserRegistrationDto;
import com.szczerbap.rssreader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserRestConntroller {

    @Autowired
    UserService userService;


    //==============================================================================
    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody UserRegistrationDto userDto){

        userService.addUser(userDto);
    }
    //==============================================================================
    public void updateUser(){

    }
    //==============================================================================

    //==============================================================================
    //public User getUserByUserName(String userName){

       // return userService.getByUsername(userName);
   // }
    //==============================================================================
    @RequestMapping(value="/{userName}",method = RequestMethod.DELETE)
    public void removeUser(@PathVariable String userName){
        System.out.println(userName);
        userService.removeUser(userService.getByUserName(userName));
}
    //==============================================================================
}
