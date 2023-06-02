package com.example.multitenantappln.controller;

import com.example.multitenantappln.entity.Employee;
import com.example.multitenantappln.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/emploeeList")
    public List<Employee> emploeeList() {
        return employeeDAO.findAll();
    }
}
