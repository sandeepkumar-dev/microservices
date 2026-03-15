package com.microservice2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice1", url ="http://localhost:8081" )
public interface WelcomeClient {

    @GetMapping("/api/v1/message")
    public String getMessage();

    @GetMapping("/api/v1/hello")
    public String getHello();

    @PostMapping("/api/v1/hi")
    public String getHello(@RequestParam String x);

    @DeleteMapping("/api/v1/delete")
    public String callDelete(@RequestParam String x);
}
