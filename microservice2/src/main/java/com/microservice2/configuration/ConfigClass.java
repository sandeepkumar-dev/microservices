package com.microservice2.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration  // Marks this class as a configuration class for Spring (used to define beans)
public class ConfigClass {

    @LoadBalanced  // Enables client-side load balancing for RestTemplate (works with Eureka/discovery server)
    @Bean          // Makes RestTemplate available as a Spring bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate(); // Standard RestTemplate to make HTTP calls to other services
    }

    @LoadBalanced  // Enables client-side load balancing for WebClient
    @Bean          // Makes WebClient.Builder available as a Spring bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder(); // Builder for creating WebClient instances for reactive HTTP calls
    }
}