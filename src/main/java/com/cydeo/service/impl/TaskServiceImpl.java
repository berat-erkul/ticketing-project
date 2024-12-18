package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ITaskService;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements ITaskService {

    @Override
    public TaskDTO save(TaskDTO task) {
        if (task.getTaskStatus()==null){ task.setTaskStatus(Status.OPEN); }
        if (task.getAssignedDate()==null){ task.setAssignedDate(LocalDate.now()); }
        if (task.getId()==null){ task.setId(UUID.randomUUID().getMostSignificantBits()); }  // This line is added to generate a random id for each task
        return super.save(task.getId(),task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(Long id, TaskDTO task) {
        super.update(id, task);
    }
}

