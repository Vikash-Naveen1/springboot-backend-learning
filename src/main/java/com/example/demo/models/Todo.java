package com.example.demo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    long id;
    @NotBlank
    @NotNull
    @Schema(name="title", example="Task 1")
    String title;
    @NotBlank
    @NotNull
    String description;
    @Column(name="is_completed")
    boolean completed;
}
