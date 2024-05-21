package com.example.Quest1.Quest1.controllers;

import com.example.Quest1.Quest1.repository.EmployeeRepository;
import com.example.Quest1.Quest1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        return employeeRepository.deleteById(id)+" Employee delete from the database";
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee e) {
        return employeeRepository.save(e)+" Employee saved successfully";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@RequestBody Employee e, @PathVariable int id) {
        return employeeRepository.update(e, id)+" Employee updated successfully";
    }
}
