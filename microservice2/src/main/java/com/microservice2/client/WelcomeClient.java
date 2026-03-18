package com.microservice2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "microservice1",  // Logical name of the microservice we want to call
        url = "http://localhost:8081" // Base URL of the service (can also use service discovery)
)
public interface WelcomeClient {

    @GetMapping("/api/v1/message")  // Maps to Microservice1's GET /message endpoint
    public String getMessage();      // Calls microservice and returns its response

    @GetMapping("/api/v1/hello")    // Maps to Microservice1's GET /hello endpoint
    public String getHello();        // Calls microservice and returns its response

    @PostMapping("/api/v1/hi")      // Maps to Microservice1's POST /hi endpoint
    public String getHello(
            @RequestParam String x  // Sends query parameter 'x' to microservice1
    );

    @DeleteMapping("/api/v1/delete") // Maps to Microservice1's DELETE /delete endpoint
    public String callDelete(
            @RequestParam String x   // Sends query parameter 'x' to microservice1
    );
}