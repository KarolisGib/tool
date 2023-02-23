package com.employee.tool.controller;

import com.employee.tool.controller.resource.UploadFileResponse;
import com.employee.tool.repository.model.Employee;
import com.employee.tool.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping(path = "/mapping") //http://localhost:8080/mapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/post/upload-file") //http://localhost:8080/mapping/post/upload-file
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return new UploadFileResponse(false);
        }

        var fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
        employeeService.insertEmployees(fileReader);

        return new UploadFileResponse(true);
    }

    @GetMapping(path = "/get/employee/all") //http://localhost:8080/mapping/get/employee/all
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
