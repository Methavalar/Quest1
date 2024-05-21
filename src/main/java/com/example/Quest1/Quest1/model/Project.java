package com.example.Quest1.Quest1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "projects")
public class Project {

    @Id
    private int id;

    private String name;

}
