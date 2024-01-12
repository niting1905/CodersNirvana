package com.example.Rest.controller;

import com.example.Rest.threads.ThreadExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ThreadExample threadExample;

    @GetMapping("/testApi")
    public HttpStatus testApi(){
        threadExample.executorService();

        return HttpStatus.OK;
    }
}
