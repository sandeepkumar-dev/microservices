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

@RestController  // Marks this class as a REST controller
@RequestMapping("/api/v2/ms2")  // Base URL for this controller
public class Microservice2Controller {

    @Autowired
    private WebClient.Builder webClient;  // Injects WebClient.Builder for reactive calls

    @Autowired
    private WelcomeService welcomeService;  // Injects service layer to handle business logic

    /************* Using CompletableFuture via Service Layer ******************/
    // Endpoint: http://localhost:8082/api/v2/ms2/call
    @GetMapping("/call")
    public String getMessageFromMicroservice1() throws Exception {

        // Calls Microservice1 asynchronously using WelcomeService
        CompletableFuture<String> future = welcomeService.callWelcomeService();

        System.out.println("Welcome..................Welcome Sandeep");  // Just a log message
        return future.get();  // Waits for result and returns it
    }

    /******************* WebClient (Reactive, non-blocking) **********************
     @GetMapping("/call")
     public Mono<String> getMessageFromMicroservice1() {

     // Calls Microservice1 using WebClient
     return webClient.build()
     .get()
     .uri("http://microservice1/api/v1/message")  // Microservice1 URL
     .retrieve()
     .bodyToMono(String.class);  // Returns Mono<String> reactively
     }
      ******************* WebClient **********************/

    /******************* RestTemplate (Synchronous, blocking) **********************
     @Autowired
     private RestTemplate restTemplate;

     // Endpoint: http://localhost:8082/api/v2/ms2/call
     @GetMapping("/call")
     public String getMessageFromMicroservice1() {

     // Calls Microservice1 synchronously using RestTemplate
     String value = restTemplate.getForObject("http://microservice1/api/v1/message", String.class);
     return value;
     }
      ******************* RestTemplate **********************/

    /******************* FeignClient Configuration **********************
     @Autowired
     private WelcomeClient welcomeClient;  // Injects FeignClient to call Microservice1

     @GetMapping("/call")
     public String getMessageFromMicroservice1() {

     // Calls multiple endpoints of Microservice1 via FeignClient
     return welcomeClient.getMessage() + " " +
     welcomeClient.getHello() + " " +
     welcomeClient.getHello("Hi Hello Hi") + " " +
     welcomeClient.callDelete("Deleting");
     }
      ******************* FeignClient **********************/
}