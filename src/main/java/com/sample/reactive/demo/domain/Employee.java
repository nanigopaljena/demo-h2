package com.sample.reactive.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private Long id;

    @Column("name")
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}
