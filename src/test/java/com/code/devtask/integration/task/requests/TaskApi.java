package com.code.devtask.integration.task.requests;

import static io.restassured.RestAssured.given;

import com.code.devtask.integration.common.requests.BaseApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TaskApi extends BaseApi {

    private static final String apiUrl = baseUrl + "/tasks";

    public static Response getTasks() {
        Response response = given().contentType(ContentType.JSON).when().get(apiUrl);
        return response;
    }
}
