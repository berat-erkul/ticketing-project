package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/home")
    public String userHomePage(){
        return "welcome.html";
    }

    @GetMapping("/create")
    public String createUser(){
        return "user/create";
    }
}
