package com.stronger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // 启用一个eureka 客户端
public class MicroserviceClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClient01Application.class, args);
	}
}
