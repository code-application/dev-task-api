package com.code.devtask.shared.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * ヘルスチェック用のエンドポイントを定義するコントローラー
 */
@RestController
public class HealthCheckController {

    /*
     * ヘルスチェック用エンドポイント
     * アプリケーションが正常に動作している場合「OK」を返却する
     * 
     * @return 正常に動作している場合「OK」を返却する
     */
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    @GetMapping("/healthz") // 末尾のzはタイポではなく慣習。健康データなどを扱うかは不明だが、エンドポイントの競合を避けるため
    public String healthCheck() {
        return "OK";
    }
}
