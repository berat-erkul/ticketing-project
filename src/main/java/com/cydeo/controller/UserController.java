package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final IRoleService roleService;
    private final IUserService userService;

    public UserController(IRoleService roleService, IUserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String userHomePage() {
        return "welcome.html";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.findAll());
            model.addAttribute("users", userService.findAll());
            return "user/create";
        }
        userService.save(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("roles", roleService.findAll());
            model.addAttribute("users", userService.findAll());
            return "user/update";
        }
        userService.update(user.getUserName(), user);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.deleteById(username);
        return "redirect:/user/create";
    }
}
