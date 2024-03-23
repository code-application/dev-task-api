package com.code.devtask.integration.requests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HelloApi extends BaseApi {

    private static final String apiUrl = baseUrl + "/";

    public static Response getHome() {
        Response response = given().contentType(ContentType.JSON).when().get(apiUrl);
        System.out.println("response: " + response.toString());
        return response;
    }
}
