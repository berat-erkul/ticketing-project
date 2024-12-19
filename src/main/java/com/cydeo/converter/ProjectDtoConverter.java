package com.cydeo.converter;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.IProjectService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {

    private final IProjectService projectService;

    public ProjectDtoConverter(IProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String code) {
        return projectService.findById(code);
    }
}
