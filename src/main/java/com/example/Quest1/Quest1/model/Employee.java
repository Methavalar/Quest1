package com.example.Quest1.Quest1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "employees")
public class Employee {

    @Id
    private int id;

    private String name;

}
