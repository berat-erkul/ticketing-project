package com.cydeo.controller;

import com.cydeo.service.IRoleService;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }
}
