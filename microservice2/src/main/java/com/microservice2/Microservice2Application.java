package com.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication  // Marks this as a Spring Boot application (auto-configuration + component scan)
@EnableDiscoveryClient  // Registers this microservice with Eureka for service discovery
@EnableFeignClients     // Enables FeignClient usage to call other microservices declaratively
@EnableAsync            // Enables asynchronous method execution (for @Async or CompletableFuture)
public class Microservice2Application {

    public static void main(String[] args) {
        // Entry point of Microservice2 - starts the Spring Boot application
        SpringApplication.run(Microservice2Application.class, args);
    }

}