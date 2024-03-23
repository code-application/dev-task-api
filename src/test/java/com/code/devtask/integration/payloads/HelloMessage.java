package com.code.devtask.integration.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloMessage {

    @JsonProperty
    private String message;

    public String getMassage() {
        return message;
    }
}
