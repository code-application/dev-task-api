package com.code.devtask.task.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.code.devtask.task.domain.Task;

import lombok.Getter;

@Getter
public class GetTaskResponse {
    private List<Task> taskList;

    public GetTaskResponse(List<Task> tasks) {
        this.taskList = tasks;
    }
}