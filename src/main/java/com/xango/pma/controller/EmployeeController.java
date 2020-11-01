package com.xango.pma.controller;

import com.xango.pma.domain.EmployeeDto;
import com.xango.pma.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.listEmployees());
        return "employee/employees";
    }

    @GetMapping("/new-employee")
    public String getAddEmployeeForm(Model model, EmployeeDto employeeDto) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/new-employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(Model model, EmployeeDto employeeDto) {
        employeeService.addEmployee(employeeDto);
        return "redirect:/employees/new-employee";
    }

}
