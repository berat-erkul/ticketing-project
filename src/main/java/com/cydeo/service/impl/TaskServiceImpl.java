package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ITaskService;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements ITaskService {

    @Override
    public TaskDTO save(TaskDTO task) {
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

