package com.szczerbap.rssreader.controller;

import com.szczerbap.rssreader.data.dto.AllUserDto;
import com.szczerbap.rssreader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

    //===============================================================
    @RequestMapping(method = RequestMethod.GET)
    public List<AllUserDto> getAllUsers(){

        return userService.getAllUsers();

    }
    //================================================================
    @RequestMapping(value="/{userName}",method = RequestMethod.DELETE)
    public void removeUser(@PathVariable String userName){
        System.out.println(userName);
        userService.removeUser(userService.getByUserName(userName));
    }
    //================================================================
}
