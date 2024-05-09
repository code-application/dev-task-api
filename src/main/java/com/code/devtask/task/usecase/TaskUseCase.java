package com.code.devtask.task.usecase;

import java.util.List;

import com.code.devtask.base.annotation.UseCase;
import com.code.devtask.task.domain.Task;
import com.code.devtask.task.domain.TaskRepository;

@UseCase
public class TaskUseCase {

    private TaskRepository taskRepository;

    /*
     * タスクのリストを取得する
     * 
     * @return List<Task>
     */
    public List<Task> getTasks() {
        List<Task> tasks = taskRepository.fetchTasks();
        return tasks;
    }
}
