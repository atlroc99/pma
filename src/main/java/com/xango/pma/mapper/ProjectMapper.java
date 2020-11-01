package com.xango.pma.mapper;

import com.xango.pma.domain.ProjectDto;
import com.xango.pma.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectDto covertToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(project.getName());
        projectDto.setStage(project.getStage());
        projectDto.setCreatedOn(project.getCreatedOn());
        return projectDto;
    }

    public Project covertToProjectDto(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setStage(projectDto.getStage());
        project.setCreatedOn(projectDto.getCreatedOn());
        return project;
    }
}
