package com.xango.pma.controller;

import com.xango.pma.domain.ProjectDto;
import com.xango.pma.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
@Slf4j
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String listProjects(Model model) {
        List<ProjectDto> projectDtos = projectService.listProjects();
        model.addAttribute("projects", projectDtos);
        return "project/projects";
    }


    @GetMapping("/new-project")
    public String getNewProjectForm(Model model) {
        model.addAttribute("projectDto", new ProjectDto());
        return "project/new-project-form";
    }


    @PostMapping("/addProject")
    public String addProject(ProjectDto projectDto, Model model) {
        projectService.addProject(projectDto);
        return "redirect:/projects/new-project";
    }
}
