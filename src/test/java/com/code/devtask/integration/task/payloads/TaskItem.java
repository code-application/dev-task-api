package com.code.devtask.integration.task.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskItem {
    @JsonProperty
    private String id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
