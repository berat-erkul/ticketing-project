package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.IProjectService;
import com.cydeo.service.ITaskService;
import com.cydeo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final IProjectService projectService;
    private final IUserService userService;
    private final ITaskService taskService;

    public TaskController(IProjectService projectService, IUserService userService, ITaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model, ModelMap modelMap){
        model.addAttribute("task",new TaskDTO());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());
        model.addAttribute("tasks",taskService.findAll());
        System.out.println(taskService.findAll().toArray().toString());
        return "task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("task")TaskDTO task){
        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

}
