package com.code.devtask.integration.common.checks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.code.devtask.integration.common.requests.ErrorApi;
import com.code.devtask.integration.task.requests.TaskApi;
import com.code.devtask.shared.exception.ErrorResponse;

import io.restassured.response.Response;

@SpringBootTest
@DisplayName("全体のエラーハンドリングのケース")
public class ErrorHandlingIntegrationTest {

    @ParameterizedTest
    @CsvSource({ "taskss", "ap/tasks", "tasks/99" })
    @DisplayName("未定義のエンドポイントにアクセスするとNOT FOUND例外が発生する")
    public void getUndefinedPathShouldReturn404(String path) {
        // Arrange
        // do nothing

        // Act
        Response response = ErrorApi.getUndefinedPath(path);

        // Assert
        assertEquals(404, response.getStatusCode());

        ErrorResponse error = response.as(ErrorResponse.class);
        assertEquals(404, error.getStatus());
        assertEquals("4001", error.getCode());
        assertThat(error.getMessage(), startsWith("Request Not Found"));
    }

    @Test
    @DisplayName("未定義のHTTPメソッドで既存のエンドポイントにアクセスするとNOT FOUND例外が発生する")
    public void postWrongMethodWithDefinedPathShouldReturn404() {
        // Arrange
        // do nothing

        // Act
        Response response = ErrorApi.postWrongMethodWithDefinedPath();

        // Assert
        assertEquals(404, response.getStatusCode());

        ErrorResponse error = response.as(ErrorResponse.class);
        assertEquals(404, error.getStatus());
        assertEquals("4001", error.getCode());
        assertThat(error.getMessage(), startsWith("Request Not Found"));
    }

    @Test
    @DirtiesContext
    @DisplayName("未定義のHTTPメソッドで既存のエンドポイントにアクセスするとNOT FOUND例外が発生する")
    public void getRequestWithWrongDatabaseURIShouldReturn500() {
        // Arrange
        // 誤ったデータベース接続先を設定する
        setWrongDatabaseProperties();

        // Act
        Response response = TaskApi.getTasks();

        // Assert
        assertEquals(500, response.getStatusCode());

        ErrorResponse error = response.as(ErrorResponse.class);
        assertEquals(500, error.getStatus());
        assertEquals("9000", error.getCode());
        assertThat(error.getMessage(), startsWith("System Error Occurred"));
    }

    // テストデータベース用のプロパティを設定するヘルパーメソッド
    private void setWrongDatabaseProperties() {
        System.setProperty("spring.datasource.url", "jdbc:h2:mem:testdb");
    }
}
