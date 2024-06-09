package com.code.devtask.task.domain;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;

/*
 * 「タスク」を表すドメインクラス
 */
@Getter
public class Task {

    private UUID id;
    private String title;
    private String description;

    /*
     * コンストラクタ
     * 
     * @param title タスクのタイトル
     * 
     * @param description タスクの説明
     */
    public Task(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
    }

}
