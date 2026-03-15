package com.microservice2.controller;


import com.microservice2.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservice2.client.WelcomeClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/api/v2/ms2")
public class Microservice2Controller {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private  WelcomeService welcomeService;

    //(http://localhost:8082/api/v2/ms2)
    @GetMapping("/call")
    public String getMessageFromMicroservice1() throws Exception {

        CompletableFuture<String> future = welcomeService.callWelcomeService();

        System.out.println("Welcome..................Welcome Sandeep");
        return future.get();
    }

    /*******************This is  for Webclient   **********************
    @GetMapping("/call")
    public Mono<String> getMessageFromMicroservice1() {

        return webClient.build()
                .get()
                .uri("http://microservice1/api/v1/message")
                .retrieve()
                .bodyToMono(String.class);
    }
     ******************* WebClient   **********************/

    /*******************This is  for RestTemplate   **********************
    @Autowired
    private RestTemplate restTemplate;

    //(http://localhost:8082/api/v2/ms2)
    @GetMapping("/call")
    public String getMessageFromMicroservice1() {
        String value = restTemplate.getForObject("http://microservice1/api/v1/message", String.class);
        return value;
    }
    ******************* RestTemplate   **********************/

/**************************** FeignClient Configuration *********************************
 *
 @Autowired private WelcomeClient welcomeClient;

 @GetMapping("/call") public String getMessageFromMicroservice1() {
 return welcomeClient.getMessage() + " " +
 welcomeClient.getHello() + " " +
 welcomeClient.getHello("Hi Hello Hi") + " " +
 welcomeClient.callDelete("Deleting");
 }
  ********************** FeignClient *****************************/
}
