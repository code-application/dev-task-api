package com.code.devtask.task.controller;

import java.util.UUID;

import com.code.devtask.task.domain.Task;

import lombok.Getter;

/*
 * タスク一覧取得APIが返却するレスポンス
 * Taskの一部
 */
@Getter
public class GetTaskResponseEntity {
    private UUID id;
    private String title;
    private String description;

    public GetTaskResponseEntity(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
    }
}