package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements IProjectService{

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
}
