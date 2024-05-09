package com.code.devtask.task.domain;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Task {

    private UUID id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Task(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Task(String title, String description, LocalDate createdAt, LocalDate updatedAt) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
