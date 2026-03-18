package com.microservice1.controller;

import org.springframework.web.bind.annotation.*;

@RestController  // Marks this class as a REST controller (handles HTTP requests and returns responses)
@RequestMapping("/api/v1")  // Base URL for all endpoints in this controller
public class WelcomeController {

    // Endpoint: http://localhost:8081/api/v1/message
    @GetMapping("/message")  // Handles HTTP GET request
    public String getMessage(){
        return "Welcome";  // Returns a simple welcome message
    }

    @GetMapping("/hello")  // Handles HTTP GET request
    public String getHello(){
        return "Hello";  // Returns hello message
    }

    @PostMapping("/hi")  // Handles HTTP POST request
    public String getHello(
            @RequestParam String x  // Reads query parameter 'x' from request
    ){
        return x;  // Returns the same value received from client
    }

    @DeleteMapping("/delete")  // Handles HTTP DELETE request
    public String callDelete(
            @RequestParam String x  // Reads query parameter 'x'
    ){
        return x;  // Returns the same value received
    }
}