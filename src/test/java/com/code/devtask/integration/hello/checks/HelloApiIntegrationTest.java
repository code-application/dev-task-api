package com.code.devtask.integration.hello.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.code.devtask.integration.hello.payloads.HelloMessage;
import com.code.devtask.integration.hello.requests.HelloApi;

import io.restassured.response.Response;

public class HelloApiIntegrationTest {

    @Test
    @DisplayName("APIテストサンプル; 'Hello, CODE'を返却する")
    public void getHomeShouldReturn200AndCorrectMessage() {
        // Arrange
        // do nothing

        // Act
        Response response = HelloApi.getHome();

        // Assert
        assertEquals(200, response.getStatusCode());
        HelloMessage message = response.as(HelloMessage.class);
        assertEquals("Hello, CODE!", message.getMassage());
    }
}
