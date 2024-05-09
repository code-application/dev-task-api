package com.code.devtask.task.controller;

import org.springframework.web.bind.annotation.RestController;

import com.code.devtask.task.domain.Task;
import com.code.devtask.task.usecase.TaskUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TaskController {

    @Autowired
    private TaskUseCase taskUseCase;

    @GetMapping("/api/tasks")
    public GetTaskResponse getTasks(@RequestParam String param) {
        List<Task> tasks = taskUseCase.getTasks();
        GetTaskResponse response = new GetTaskResponse(tasks);
        return response;
    }

}
