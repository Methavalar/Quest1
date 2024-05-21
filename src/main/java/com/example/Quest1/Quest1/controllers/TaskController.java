package com.example.Quest1.Quest1.controllers;

import com.example.Quest1.Quest1.repository.TaskRepository;
import com.example.Quest1.Quest1.dto.TaskResponse;
import com.example.Quest1.Quest1.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<TaskResponse> findAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public TaskResponse findTaskById(@PathVariable int id) {
        return taskRepository.findById(id);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTaskById(@PathVariable int id) {
        return taskRepository.deleteById(id)+" Task delete from the database";
    }

    @PostMapping("/tasks")
    public String saveTask(@RequestBody Task e) {
        return taskRepository.save(e)+" Task saved successfully";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@RequestBody Task e, @PathVariable int id) {
        return taskRepository.update(e, id)+" Task updated successfully";
    }
}
