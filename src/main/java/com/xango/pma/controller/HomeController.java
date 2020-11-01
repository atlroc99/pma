package com.xango.pma.controller;

import com.xango.pma.service.EmployeeService;
import com.xango.pma.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public HomeController(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("employees", employeeService.listEmployees());
        model.addAttribute("projects", projectService.listProjects());
        return "/main/index";
    }
}
