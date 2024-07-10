package com.code.devtask.integration.task.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.code.devtask.integration.task.payloads.TaskItem;
import com.code.devtask.integration.task.requests.TaskApi;

import io.restassured.response.Response;

@SpringBootTest
@DisplayName("タスクAPIのテスト")
public class TaskApiIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
     * セットアップメソッド
     */
    @BeforeEach
    public void setup() {
        // 各テストケース実行前にテーブルのデータを削除する
        // DELETE ALLではなくTRUNCATEを使用し、実行速度を速くする
        // TODO: DBデータ投入ではSQL文の実行をしないようにしたい
        // 理由：テストコードがテーブル構造と密結合してしまうため
        jdbcTemplate.execute(
                "TRUNCATE TABLE devtask.tasks");
    }

    @Test
    @DisplayName("タスクをすべて取得する")
    public void getTasksShouldReturn200AndTaskItems() {
        // Arrange
        // insert DB data 4 items with SQL
        // TODO: DBデータ投入ではSQL文の実行をしないようにしたい
        // 理由：テストコードがテーブル構造と密結合してしまうため
        jdbcTemplate.execute(
                "INSERT INTO devtask.tasks (id, title, description) VALUES ('ad950465-127f-4848-8ce3-801d4b1ad82f', 'test title 1', 'test description 1')");
        jdbcTemplate.execute(
                "INSERT INTO devtask.tasks (id, title, description) VALUES ('3527291f-71a0-496b-b4eb-ebec91b133e5', 'test title 2', 'test description 2')");
        jdbcTemplate.execute(
                "INSERT INTO devtask.tasks (id, title, description) VALUES ('5335209e-c0fe-4a8f-8de1-9ef91aa3949d', 'test title 3', 'test description 3')");
        jdbcTemplate.execute(
                "INSERT INTO devtask.tasks (id, title, description) VALUES ('f7204382-738f-41de-8fc1-493c05698d1a', 'test title 4', 'test description 4')");

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
