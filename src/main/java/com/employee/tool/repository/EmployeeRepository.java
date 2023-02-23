package com.employee.tool.repository;

import com.employee.tool.repository.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAll();
}
