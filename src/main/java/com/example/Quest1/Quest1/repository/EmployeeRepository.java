package com.example.Quest1.Quest1.repository;

import com.example.Quest1.Quest1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id=?",
                new BeanPropertyRowMapper<>(Employee.class), id);
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM reports WHERE Task_Employee_id=?", id);
        jdbcTemplate.update("DELETE FROM tasks WHERE Employee_id=?", id);
        jdbcTemplate.update("DELETE FROM project_has_employee " +
                "WHERE project_has_employee.Employee_id = ?", id);
        return jdbcTemplate.update("DELETE FROM employees WHERE id = ?", id);
    }

    public int save(Employee e) {
        return jdbcTemplate.update("INSERT INTO employees (name) VALUES (?)", e.getName());
    }

    public int update(Employee e, int id) {
        return jdbcTemplate.update("UPDATE employees SET name = ? WHERE id = ?", e.getName(), id);
    }
}
