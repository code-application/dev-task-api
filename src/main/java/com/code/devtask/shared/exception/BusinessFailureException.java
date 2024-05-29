package com.code.devtask.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessFailureException extends RuntimeException {
    public BusinessFailureException(String message) {
        super(message);
    }
}
