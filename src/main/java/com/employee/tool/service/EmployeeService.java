package com.employee.tool.service;

import com.employee.tool.repository.EmployeeRepository;
import com.employee.tool.repository.model.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void insertEmployees(BufferedReader fileReader) throws IOException {
        var csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        var firstLine = true;
        for (CSVRecord csvRecord : csvRecords) {
            if (!firstLine) {
                var employee = new Employee();
                employee.setName(csvRecord.get(0));
                employee.setEmail(csvRecord.get(1));
                employee.setPhone(csvRecord.get(2));

                employeeRepository.save(employee);
            } else {
                firstLine = false;
            }
        }
    }
}