package com.example.Quest1.Quest1.repository;

import com.example.Quest1.Quest1.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Project> findAll() {
        return jdbcTemplate.query("SELECT * FROM projects", new BeanPropertyRowMapper<Project>(Project.class));
    }

    public Project findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM projects WHERE id=?", new BeanPropertyRowMapper<Project>(Project.class), id);
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM project_has_employee" +
                " WHERE project_has_employee.Project_id = ?", id);
        return jdbcTemplate.update("DELETE FROM projects WHERE id=?", id);
    }

    public int save(Project e) {
        return jdbcTemplate.update("INSERT INTO projects (name) VALUES (?)", new Object[] {e.getName()});
    }

    public int update(Project e, int id) {
        return jdbcTemplate.update("UPDATE projects SET name = ? WHERE id = ?", new Object[] {e.getName(), id});
    }
}
