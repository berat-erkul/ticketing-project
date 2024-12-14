package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.IRoleService;
import com.cydeo.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final IRoleService roleService;
    private final IUserService userService;

    public DataGenerator(IRoleService roleService, IUserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1l,"Admin");
        RoleDTO managerRole = new RoleDTO(2l,"Manager");
        RoleDTO employeeRole = new RoleDTO(3l,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("Berat", "Erkul", "berat-erkul00", Gender.MALE, "5542340000", "123456", adminRole);
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

    }


}
