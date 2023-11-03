package com.lizana.microservicecreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class MicroserviceCreditCardApplication {

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}


	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCreditCardApplication.class, args);
	}

}
