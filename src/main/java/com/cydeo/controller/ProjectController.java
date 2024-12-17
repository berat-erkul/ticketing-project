package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.impl.ProjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        System.out.println(projectService.findAll().get(0).getProjectName());
        return "project/create";
    }

}
