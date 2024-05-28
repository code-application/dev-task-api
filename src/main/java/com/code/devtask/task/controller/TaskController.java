package com.code.devtask.task.controller;

import org.springframework.web.bind.annotation.RestController;

import com.code.devtask.task.domain.Task;
import com.code.devtask.task.usecase.GetTaskUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * タスクドメインのRESTコントローラー
 * APIのリクエストを受け取り、レスポンスを返却する
 */
@RestController
public class TaskController {

    @Autowired
    private GetTaskUseCase getTaskUseCase;

    /*
     * すべてのタスクを取得する
     * 
     * @return すべてのタスクを含むリスト
     */
    @GetMapping("/api/tasks")
    public GetTaskResponse getTasks() {
        List<Task> tasks = getTaskUseCase.getTasks();
        GetTaskResponse response = new GetTaskResponse(tasks);
        return response;
    }

}
