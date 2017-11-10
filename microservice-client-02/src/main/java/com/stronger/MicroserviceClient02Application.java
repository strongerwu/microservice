package com.stronger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceClient02Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClient02Application.class, args);
	}
}
