package com.cydeo.dto;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName; //key of the object (keep it unique)
    private Gender gender;
    private String phone;
    private String passWord;
    private RoleDTO role;  //Long id , String description
}
