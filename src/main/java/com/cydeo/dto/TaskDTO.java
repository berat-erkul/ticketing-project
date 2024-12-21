package com.cydeo.dto;

import com.cydeo.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;

    @NotNull(message = "Please select a Project")
    private ProjectDTO project;

    @NotNull(message = "Please select an Employee")
    private UserDTO assignedEmployee;

    @NotBlank(message = "Task Subject is a required field")
    private String taskSubject;

    @NotBlank(message = "Task Detail is a required field")
    private String taskDetail;

    private LocalDate assignedDate;
    private Status taskStatus;

}
