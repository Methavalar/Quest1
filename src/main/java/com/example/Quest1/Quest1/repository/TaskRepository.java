package com.example.Quest1.Quest1.repository;

import com.example.Quest1.Quest1.dto.TaskResponse;
import com.example.Quest1.Quest1.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TaskResponse> findAll() {
        return jdbcTemplate.query("SELECT tasks.id, tasks.name, employees.name as employee FROM tasks, employees " +
                        "WHERE tasks.Employee_id = employees.id",
                new BeanPropertyRowMapper<>(TaskResponse.class));
    }

    public TaskResponse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT tasks.id, tasks.name, employees.name as employee FROM tasks, employees " +
                        "WHERE tasks.Employee_id = employees.id AND tasks.id = ?",
                new BeanPropertyRowMapper<>(TaskResponse.class), id);
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM reports WHERE Task_id=?", id);
        return jdbcTemplate.update("DELETE FROM tasks WHERE id=?", id);
    }

    public int save(Task e) {
        return jdbcTemplate.update("INSERT INTO tasks (name, Employee_id) VALUES (?, ?)", e.getName(), e.getEmployeeId());
    }

    public int update(Task e, int id) {
        return jdbcTemplate.update("UPDATE tasks SET name = ?, Employee_id = ? WHERE id = ?", e.getName(), e.getEmployeeId(), id);
    }
}
