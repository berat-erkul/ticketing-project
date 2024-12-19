package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.IProjectService;
import com.cydeo.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements IProjectService{

    private final ITaskService taskService;

    public ProjectServiceImpl(ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        if (object.getProjectStatus()==null){ object.setProjectStatus(Status.OPEN);}
        return super.save(object.getProjectCode(),object);
    }

    @Override
    public ProjectDTO findById(String code) {
        return super.findById(code);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String code) {
        super.deleteById(code);
    }

    @Override
    public void update(String code, ProjectDTO object) {
        if (object.getProjectStatus()==null){ object.setProjectStatus(findById(code).getProjectStatus()); }
        super.update(code, object);
    }

    @Override
    public void complete(String projectCode) {
        findById(projectCode).setProjectStatus(Status.COMPLETED);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        List<ProjectDTO> projectList = findAll()
                .stream()
                .filter(project -> project.getAssignedManager().equals(manager)) //Berat
                .map(project-> {

                    int completeTaskCount = (int) taskService.findAll().stream()
                            .filter(task -> task.getProject().equals(project) && task.getTaskStatus().equals(Status.COMPLETED))
                            .count();

                    int unfinishedTaskCount = (int) taskService.findAll().stream().
                            filter(task ->task.getProject().equals(project) && task.getTaskStatus() != (Status.COMPLETED))
                            .count();

                    project.setCompleteTaskCounts(completeTaskCount);
                    project.setUnfinishedTaskCounts(unfinishedTaskCount);
                    return project;
                })
                .collect(Collectors.toList());

        return projectList;
    }
}
