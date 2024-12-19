package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;

import java.util.List;

public interface ITaskService extends ICrudService<TaskDTO,Long>{
    List<TaskDTO> findAllTaskByStatusNot(Status status);
}
