package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
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
    public String createTask(Model model, ModelMap modelMap) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());
        System.out.println(taskService.findAll().toArray().toString());
        return "task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("task") TaskDTO task) {
        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());
        return "task/update";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@ModelAttribute("task") TaskDTO task, @PathVariable("id") Long id, Model model) {
        task.setId(id);       //This point was important!!!
        taskService.update(id, task);
        return "redirect:/task/create";
    }

    @GetMapping("/employee/pending-tasks")
    public String employeePendingTasks(Model model){
        model.addAttribute("tasks",taskService.findAllTaskByStatusNot(Status.COMPLETED));
        return "task/pending-tasks";
    }

    @GetMapping("/employee/archive")
    public String employeeArchiveTasks(Model model){
        model.addAttribute("tasks",taskService.findAllTaskByStatus(Status.COMPLETED));
        return "task/archive";
    }

    @GetMapping("/employee/edit/{id}")
    public String employeeEditTask(@PathVariable("id") Long id, Model model){
        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("statuses",Status.values());
        model.addAttribute("tasks",taskService.findAllTaskByStatusNot(Status.COMPLETED));
        return "task/status-update";
    }

    @PostMapping("/employee/update/{id}")
    public String employeeUpdateTask(@ModelAttribute("task") TaskDTO task, @PathVariable Long id){

        taskService.updateStatus(id,task);

        return "redirect:/task/employee/pending-tasks";
    }


//    @PostMapping("/update/{id}")
//    public String updateTask(@ModelAttribute("task")TaskDTO task){
//
//        taskService.update(task);
//
//        return "redirect:/task/create";
//    }
    //We can also design like that -> Spring understand what are we doing. -There is a Path variable
    //                                                                     -There is a ModelAttribute
    //                                                                     -ModelAttribute has path variable as a field
    //Everything is clear for Spring
}
