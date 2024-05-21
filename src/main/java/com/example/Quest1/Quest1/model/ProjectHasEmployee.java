package com.example.Quest1.Quest1.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "project_has_employee")
public class ProjectHasEmployee {

    @Column("Project_id")
    private int projectId;

    @Column("Employee_id")
    private int employeeId;
}
