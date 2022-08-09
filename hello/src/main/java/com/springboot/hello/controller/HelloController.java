package com.springboot.hello.controller;
//사용자/클라이언트가 입력한 값에 대한 응답 수행

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
