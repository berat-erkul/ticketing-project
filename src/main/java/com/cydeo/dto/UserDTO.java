package com.cydeo.dto;

import com.cydeo.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    @Size(max = 15, min = 3)
    private String firstName;

    @NotBlank
    @Size(max = 15, min = 3)
    private String lastName;

    @NotBlank
    @Email
    private String userName; //key of the object (keep it unique)

    @NotNull
    private Gender gender;

    @NotBlank
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}-\\d{2}")
    private String phone;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, include uppercase, lowercase, a digit, and a special character.")
    private String password;

    @NotNull
    private RoleDTO role;  //Long id , String description
}
