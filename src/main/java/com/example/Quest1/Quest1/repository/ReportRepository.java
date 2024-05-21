package com.example.Quest1.Quest1.repository;

import com.example.Quest1.Quest1.dto.ReportResponse;
import com.example.Quest1.Quest1.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ReportResponse> findAll() {
        return jdbcTemplate.query("SELECT reports.id, reports.name, tasks.name as task, employees.name as employee " +
                        "FROM reports, tasks, employees " +
                        "WHERE reports.Task_id = tasks.id AND reports.Task_Employee_id = employees.id ",
                new BeanPropertyRowMapper<>(ReportResponse.class));
    }

    public ReportResponse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT reports.id, reports.name, tasks.name as task, employees.name as employee " +
                        "FROM reports, tasks, employees " +
                        "WHERE reports.Task_id = tasks.id AND reports.Task_Employee_id = employees.id AND reports.id = ?",
                new BeanPropertyRowMapper<>(ReportResponse.class), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM reports WHERE id=?", id);
    }

    public int save(Report e) {
        return jdbcTemplate.update("INSERT INTO reports (name, Task_id, Task_Employee_id) VALUES (?, ?, ?)",
                e.getName(), e.getTaskId(), e.getTaskEmployeeId());
    }

    public int update(Report e, int id) {
        return jdbcTemplate.update("UPDATE reports SET name = ?, Task_id = ?, Task_Employee_id = ? WHERE id = ?",
                e.getName(), e.getTaskId(), e.getTaskEmployeeId(), id);
    }
}
