package com.microservice1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {

    //http://localhost:8081/api/v1/message
    @GetMapping("/message")
    public String getMessage(){
        return "Welcome";
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @PostMapping("/hi")
    public String getHello(
            @RequestParam String x
    ){
        return x;
    }

    @DeleteMapping("/delete")
    public String callDelete(
            @RequestParam String x
    ){
        return x;
    }
}
