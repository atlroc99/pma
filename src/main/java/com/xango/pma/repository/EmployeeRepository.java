package com.xango.pma.repository;

import com.xango.pma.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByLastName (String lastName);
    Employee findByEmail(String email);
}
