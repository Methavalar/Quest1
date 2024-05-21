package com.example.Quest1.Quest1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "reports")
public class Report {

    @Id
    private int id;

    private String name;

    @Column("Task_id")
    private int taskId;

    @Column("Task_Employee_id")
    private int taskEmployeeId;
}
