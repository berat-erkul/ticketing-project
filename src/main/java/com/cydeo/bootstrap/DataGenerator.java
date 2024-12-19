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
import com.cydeo.service.impl.UserServiceImpl;
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

        UserDTO user1 = new UserDTO("John", "Kesy", "john@cydeo.com", Gender.MALE, "7459684532", "Abc1",  managerRole);
        UserDTO user5 = new UserDTO("Mike", "Smith", "mike@cydeo.com", Gender.MALE, "7459684532", "Abc2",  adminRole);
        UserDTO user2 = new UserDTO("Delisa", "Norre", "delisa@cydeo.com", Gender.FEMALE, "8567412358", "123",  managerRole);
        UserDTO user3 = new UserDTO("Craig", "Jark", "craig@cydeo.com", Gender.MALE, "7777775566", "Abc3",  employeeRole);
        UserDTO user4 = new UserDTO("Shaun", "Hayns", "shaun@cydeo.com", Gender.MALE, "3256987412", "Abc4",  managerRole);
        UserDTO user6 = new UserDTO("Elizabeth", "Loren", "elizabeth@cydeo.com", Gender.FEMALE, "5306987412", "Abc4",  employeeRole);
        UserDTO user7 = new UserDTO("Maria", "Ada", "maria@cydeo.com", Gender.FEMALE, "9996987412", "Abc4",  employeeRole);
        UserDTO user8 = new UserDTO("Bill", "Matt", "bill@cydeo.com", Gender.MALE, "8881239846", "Abc4",  employeeRole);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), Status.OPEN ,"Creating Controllers");
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), Status.OPEN, "Creating Database");
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(32),Status.IN_PROGRESS, "Creating Container");


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
