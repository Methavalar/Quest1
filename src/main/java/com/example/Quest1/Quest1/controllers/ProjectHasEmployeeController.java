package com.example.Quest1.Quest1.controllers;

import com.example.Quest1.Quest1.repository.ProjectHasEmployeeRepository;
import com.example.Quest1.Quest1.dto.ProjectHasEmployeeResponse;
import com.example.Quest1.Quest1.model.ProjectHasEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectHasEmployeeController {

    @Autowired
    private ProjectHasEmployeeRepository projectHasEmployeeRepository;

    @GetMapping("/ProjectHasEmployee")
    public List<ProjectHasEmployeeResponse> findAllProjectHasEmployee() {
        return projectHasEmployeeRepository.findAll();
    }

    @DeleteMapping("/ProjectHasEmployee")
    public String deleteProjectHasEmployeeById(@RequestBody ProjectHasEmployee e) {
        return projectHasEmployeeRepository.deleteByIds(e)+" ProjectHasEmployee delete from the database";
    }

    @PostMapping("/ProjectHasEmployee")
    public String saveProjectHasEmployee(@RequestBody ProjectHasEmployee e) {
        return projectHasEmployeeRepository.save(e)+" ProjectHasEmployee saved successfully";
    }
}
