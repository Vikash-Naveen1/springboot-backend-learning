package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    long id;
    String title;
    String description;
    @Column(name="is_completed")
    boolean completed;
}
