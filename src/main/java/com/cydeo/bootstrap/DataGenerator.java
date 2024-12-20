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

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "7459684532", "Abc1", "Abc1", Gender.MALE, managerRole);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "7459684532", "Abc2", "Abc2", Gender.MALE, adminRole);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "8567412358", "123", "123", Gender.FEMALE, managerRole);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "7777775566","Abc3","Abc3", Gender.MALE, employeeRole);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com",  "3256987412", "Abc4", "Abc4",Gender.MALE, managerRole);
        UserDTO user6 = new UserDTO("Elizabeth",
                "Loren", "elizabeth@cydeo.com",  "5306987412", "Abc4", "Abc4",Gender.FEMALE, employeeRole);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com",  "9996987412","Abc4","Abc4", Gender.FEMALE, employeeRole);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "8881239846", "Abc4", "Abc4", Gender.MALE, employeeRole);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Container", Status.IN_PROGRESS);


        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);


        TaskDTO task1 = new TaskDTO(1L,project1, user8, "Controller", "Request Mapping",  LocalDate.now().minusDays(4), Status.IN_PROGRESS);
        TaskDTO task2 = new TaskDTO(2L,project3, user3, "Configuration", "Database Connection", LocalDate.now().minusDays(12), Status.COMPLETED);
        TaskDTO task3 = new TaskDTO(3L,project3, user6, "Mapping", "One-To-Many", LocalDate.now().minusDays(8), Status.COMPLETED);
        TaskDTO task4 = new TaskDTO(4L,project2, user7, "Dependency Injection", "Autowired", LocalDate.now().minusDays(20), Status.IN_PROGRESS);

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);
    }

}
