package com.code.devtask.task.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository {

    List<Task> fetchTasks();
}
