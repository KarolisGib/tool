package com.employee.tool.controller;

import com.employee.tool.repository.model.Employee;
import com.employee.tool.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/mapping") //http://localhost:8080/mapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/get/employee/all") //http://localhost:8080/mapping/get/employee/all
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
