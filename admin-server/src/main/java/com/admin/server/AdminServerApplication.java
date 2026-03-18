package com.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication // Marks this as a Spring Boot application (autoconfiguration + component scan)
@EnableAdminServer     // Activates Spring Boot Admin Server features (UI for monitoring apps)
@EnableDiscoveryClient // Registers this service with a discovery server (e.g., Eureka)
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication .class, args);
	}

}
