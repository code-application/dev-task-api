package com.code.devtask.task.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/*
 * タスクの永続化を行うリポジトリのインターフェース
 */
@Mapper
public interface TaskRepository {

    /*
     * タスクの一覧を取得する
     * 
     * @return すべてのタスクを含むList
     */
    List<Task> fetchTasks();
}
