package com.code.devtask.integration.task.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.code.devtask.integration.task.payloads.TaskItem;
import com.code.devtask.integration.task.requests.TaskApi;

import io.restassured.response.Response;

@DisplayName("タスクAPIのテスト")
public class TaskApiIntegrationTest {

    @Test
    @DisplayName("タスクをすべて取得する")
    public void getTasksShouldReturn200AndTaskItems() {
        // Arrange
        // insert DB data 4 items

        // Act
        Response response = TaskApi.getTasks();

        // Assert
        assertEquals(200, response.getStatusCode());
        TaskItem[] tasks = response.as(TaskItem[].class);
        assertEquals(4, tasks.length);
    }

    @Test
    @DisplayName("タスクが存在しない場合、空のリストを返す")
    public void getTasksShouldReturn200AndNoItems() {
        // Arrange
        // do nothing

        // Act
        Response response = TaskApi.getTasks();

        // Assert
        assertEquals(200, response.getStatusCode());
        TaskItem[] tasks = response.as(TaskItem[].class);
        assertEquals(0, tasks.length);
    }
}
