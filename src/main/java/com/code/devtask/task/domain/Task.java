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
    private LocalDate createdAt;
    private LocalDate updatedAt;

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

    /**
     * MyBatisで使用するためにすべてのプロパティを引数にしたコンストラクタを定義している
     * 
     * @param id
     * @param title
     * @param description
     * @param createdAt
     * @param updatedAt
     */
    public Task(UUID id, String title, String description, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
