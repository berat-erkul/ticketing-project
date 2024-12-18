package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.impl.ProjectServiceImpl;
import com.cydeo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectService;
    private final UserServiceImpl userService;

    public ProjectController(ProjectServiceImpl projectService, UserServiceImpl userService) {
        this.projectService = projectService;
        this.userService=userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers",userService.findManagers());
        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project")ProjectDTO project){
        projectService.save(project);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model){
        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers",userService.findManagers());
        return "project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project")ProjectDTO project){
        projectService.update(project.getProjectCode(), project);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){
        projectService.complete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model){
        model.addAttribute("projects",projectService.findAll());
        return "manager/project-status";
    }
}
