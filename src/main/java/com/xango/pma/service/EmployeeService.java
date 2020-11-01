package com.xango.pma.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xango.pma.domain.EmployeeDto;
import com.xango.pma.entity.Employee;
import com.xango.pma.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    public List<EmployeeDto> listEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> objectMapper.convertValue(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto findByLastname(String lastName) {
        return objectMapper.convertValue(employeeRepository.findByLastName(lastName), EmployeeDto.class);
    }

    public EmployeeDto findByEmail(String email) {
        return objectMapper.convertValue(employeeRepository.findByEmail(email), EmployeeDto.class);
    }

    @Transactional
    public void addEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(objectMapper.convertValue(employeeDto, Employee.class));
    }

    @Transactional
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findByEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
    }

    @Transactional
    public void deleteEmployee(String email) {
        employeeRepository.deleteById(employeeRepository.findByEmail(email).getID());
    }
}
