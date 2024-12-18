package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.IProjectService;
import com.cydeo.service.IRoleService;
import com.cydeo.service.ITaskService;
import com.cydeo.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final IRoleService roleService;
    private final IUserService userService;
    private final IProjectService projectService;
    private final ITaskService taskService;

    public DataGenerator(IRoleService roleService, IUserService userService, IProjectService projectService, ITaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1l,"Admin");
        RoleDTO managerRole = new RoleDTO(2l,"Manager");
        RoleDTO employeeRole = new RoleDTO(3l,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        UserDTO user1 = new UserDTO("Berat", "Erkul", "berat-erkul00", Gender.MALE, "5542340000", "123456", managerRole);
        UserDTO user2 = new UserDTO("Ayşe", "Yılmaz", "ayse-yilmaz21", Gender.FEMALE, "5051234567", "password123", managerRole);
        UserDTO user3 = new UserDTO("Ali", "Kaya", "ali.kaya", Gender.MALE, "5339876543", "ali12345", employeeRole);
        UserDTO user4 = new UserDTO("Zeynep", "Demir", "zeynep.dmr", Gender.FEMALE, "5364567890", "zeynep2024", adminRole);
        UserDTO user5 = new UserDTO("Mehmet", "Çelik", "mehmet.clk", Gender.MALE, "5301239876", "mehmet123", managerRole);
        UserDTO user6 = new UserDTO("Elif", "Arslan", "elif.arslan", Gender.FEMALE, "5559876543", "elif456", employeeRole);
        UserDTO user7 = new UserDTO("Can", "Büyük", "can.buyuk", Gender.MALE, "5396543210", "canpass", adminRole);
        UserDTO user8 = new UserDTO("Merve", "Koç", "merve.koc", Gender.FEMALE, "5323216548", "merve1234", managerRole);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        ProjectDTO project1 = new ProjectDTO("Spring MVC", "123", user1, LocalDate.now(), LocalDate.now().plusDays(10), Status.IN_PROGRESS, "Spring MVC Project");
        ProjectDTO project2 = new ProjectDTO("Spring Boot", "124", user2, LocalDate.now(), LocalDate.now().plusDays(15), Status.IN_PROGRESS, "Spring Boot Project");
        ProjectDTO project3 = new ProjectDTO("Spring Data JPA", "125", user3, LocalDate.now(), LocalDate.now().plusDays(20), Status.IN_PROGRESS, "Spring Data JPA Project");
                        ;
        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        TaskDTO task1 = new TaskDTO(1L, project1, user1, "Task 1 Subject", "Task 1 Detail", LocalDate.now(), Status.IN_PROGRESS);
        TaskDTO task2 = new TaskDTO(2L, project2, user2, "Task 2 Subject", "Task 2 Detail", LocalDate.now(), Status.IN_PROGRESS);
        TaskDTO task3 = new TaskDTO(3L, project3, user8, "Task 3 Subject", "Task 3 Detail", LocalDate.now(), Status.IN_PROGRESS);

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);



    }


}
