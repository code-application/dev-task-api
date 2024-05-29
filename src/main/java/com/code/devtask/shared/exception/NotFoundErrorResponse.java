package com.code.devtask.shared.exception;

import org.springframework.http.HttpStatus;

public class NotFoundErrorResponse extends ErrorResponse {

    public NotFoundErrorResponse() {
        super(HttpStatus.NOT_FOUND.value(), ErrorCode.EB_NOT_FOUND, ErrorMessage.NOT_FOUND_MESSAGE);
    }
}
