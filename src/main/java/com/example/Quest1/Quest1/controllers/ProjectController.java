package com.example.Quest1.Quest1.controllers;

import com.example.Quest1.Quest1.repository.ProjectRepository;
import com.example.Quest1.Quest1.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    public Project findProjectById(@PathVariable int id) {
        return projectRepository.findById(id);
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProjectById(@PathVariable int id) {
        return projectRepository.deleteById(id)+" Project delete from the database";
    }

    @PostMapping("/projects")
    public String saveProject(@RequestBody Project e) {
        return projectRepository.save(e)+" Project saved successfully";
    }

    @PutMapping("/projects/{id}")
    public String updateProject(@RequestBody Project e, @PathVariable int id) {
        return projectRepository.update(e, id)+" Project updated successfully";
    }
}
