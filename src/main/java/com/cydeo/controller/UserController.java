package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    IRoleService roleService;

    public UserController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/home")
    public String userHomePage() {
        return "welcome.html";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        return "user/create";
    }
}
