package com.code.devtask.hello.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> home() {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Hello, CODE!");
        return map;
    }

}