package com.code.devtask.shared.exception;

import org.springframework.http.HttpStatus;

/*
 * サーバーエラーのレスポンス
 */
public class SystemErrorResponse extends ErrorResponse {

    public SystemErrorResponse() {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorCode.ES_INTERNAL_SERVER_ERROR,
                ErrorMessage.SYSTEM_ERROR_MESSAGE);
    }

}
