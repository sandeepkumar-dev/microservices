package com.microservice2.service;

import com.microservice2.client.WelcomeClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class WelcomeService {

    private final WelcomeClient welcomeClient;

    public WelcomeService (WelcomeClient welcomeClient) {
        this.welcomeClient = welcomeClient;
    }

    @Async
   public CompletableFuture<String> callWelcomeService(){

        String response = welcomeClient.getMessage();

        return CompletableFuture.completedFuture(response);
   }


}
