package com.example.Quest1.Quest1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "tasks")
public class Task {

    @Id
    private int id;

    private String name;

    @Column("Employee_id")
    private int employeeId;
}
