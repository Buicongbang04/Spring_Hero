package com.example.Hello_Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController: use to notify to spring this is the controller
@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    String sayHello(){
        return "Hello Spring Boot!";
    }
}
