package com.code.devtask.task.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.devtask.base.annotation.UseCase;
import com.code.devtask.task.domain.Task;
import com.code.devtask.task.domain.TaskRepository;

/*
 * タスク一覧を取得するユースケース
 */
@UseCase
public class GetTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    /*
     * タスクのリストを取得する
     * 
     * @return すべてのタスクを含むList
     */
    public List<Task> getTasks() {
        List<Task> tasks = taskRepository.fetchTasks();
        return tasks;
    }
}
