package com.code.devtask.shared.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /*
     * NoHandlerFoundExceptionの場合の例外ハンドリング
     * 親クラスのメソッドをオーバーライドし、カスタムのエラーレスポンスを返却する
     * 
     * @param NoHandlerFoundException 例外
     * 
     * @param HttpHeaders HTTPヘッダー
     * 
     * @param HttpStatusCode HTTPステータスコード
     * 
     * @param WebRequest リクエスト
     * 
     * @return ResponseEntity<ErrorResponse> カスタムエラーレスポンス
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        ErrorResponse error = new NotFoundErrorResponse();
        return new ResponseEntity<>(error, status);
    }

    /*
     * BusinessFailureExceptionの場合の例外ハンドリング
     * 
     * @param BusinessFailureException 業務エラー
     * 
     * @param WebRequest リクエスト
     * 
     * @return ResponseEntity<ErrorResponse> カスタムエラーレスポンス
     */
    @ExceptionHandler(BusinessFailureException.class)
    public final ResponseEntity<ErrorResponse> handleBusinessFailureException(BusinessFailureException ex,
            WebRequest request) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                ErrorCode.EB_BAD_REQUEST, ErrorMessage.BAD_REQUEST_MESSAGE + ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    /*
     * 定義していない例外すべてのハンドリング
     * 
     * @param Exception 任意の例外
     * 
     * @param WebRequest リクエスト
     * 
     * @return ResponseEntity<ErrorResponse> カスタムエラーレスポンス
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse error = new SystemErrorResponse();
        return new ResponseEntity<>(error, status);
    }

}
