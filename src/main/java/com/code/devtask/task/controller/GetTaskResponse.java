package com.code.devtask.task.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.code.devtask.task.domain.Task;

import lombok.Getter;

/*
 * タスク一覧取得APIのレスポンスを表すクラス
 */
@Getter
public class GetTaskResponse {
    private List<Task> taskList;

    /*
     * コンストラクタ
     * 
     * @param tasks 返却するタスクのリスト
     */
    public GetTaskResponse(List<Task> tasks) {
        this.taskList = tasks;
    }
}