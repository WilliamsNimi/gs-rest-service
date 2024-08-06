package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.restservice.*;

@RestController
public class EmployeeController {

    private EmployeeManager employeeManager = new EmployeeManager();

    @GetMapping("/employees")
    public Employees getEmployees(){
        return employeeManager.getAllEmployees();
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        employeeManager.addEmployee(employee);
        return new ResponseEntity<>("Employee addedd successfully ", HttpStatus.OK);
    }
}