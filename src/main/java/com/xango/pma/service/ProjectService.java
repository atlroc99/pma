package com.xango.pma.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xango.pma.domain.ProjectDto;
import com.xango.pma.entity.Project;
import com.xango.pma.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ObjectMapper objectMapper;

    public ProjectService(ProjectRepository projectRepository, ObjectMapper objectMapper) {
        this.projectRepository = projectRepository;
        this.objectMapper = objectMapper;
    }

    public List<ProjectDto> listProjects () {
        return projectRepository.findAll().stream()
                .map(project -> objectMapper.convertValue(project, ProjectDto.class))
                .collect(Collectors.toList());
    }

    public void addProject(ProjectDto projectDto) {
        projectRepository.save(objectMapper.convertValue(projectDto, Project.class));
    }
}
