package com.szczerbap.rssreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


@Controller
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user){


        return user;
    }

}
