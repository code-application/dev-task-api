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
     * MyBatis用のコンストラクタ
     * 
     * @param title タスクのタイトル
     * 
     * @param description タスクの説明
     */
    public Task(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    /*
     * MyBatis用のコンストラクタ
     * 
     * @param title タスクのタイトル
     * 
     * @param description タスクの説明
     * 
     * @param createdAt タスクの作成日
     * 
     * @param updatedAt たすくの更新日
     */
    public Task(String title, String description, LocalDate createdAt, LocalDate updatedAt) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
