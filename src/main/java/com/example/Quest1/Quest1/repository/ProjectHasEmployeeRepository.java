package com.example.Quest1.Quest1.repository;

import com.example.Quest1.Quest1.dto.ProjectHasEmployeeResponse;
import com.example.Quest1.Quest1.model.ProjectHasEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectHasEmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ProjectHasEmployeeResponse> findAll() {
        return jdbcTemplate.query("SELECT projects.name as project, employees.name as employee FROM projects " +
                        "JOIN project_has_employee ON projects.id = project_has_employee.Project_id " +
                        "JOIN employees ON employees.id = project_has_employee.Employee_id",
                new BeanPropertyRowMapper<>(ProjectHasEmployeeResponse.class));
    }

    public int deleteByIds(ProjectHasEmployee e) {
        return jdbcTemplate.update("DELETE FROM project_has_employee WHERE Project_id=? AND Employee_id = ?",
                e.getProjectId(), e.getEmployeeId());
    }

    public int save(ProjectHasEmployee e) {
        return jdbcTemplate.update("INSERT INTO project_has_employee (Project_id, Employee_id) VALUES (?, ?)",
                e.getProjectId(), e.getEmployeeId());
    }
}
