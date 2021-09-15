package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("teste spring");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean
	public RestTemplate restTemplateBuilder(RestTemplateBuilder builder) {
		
		//return new RestTemplate();
		return builder.build();
	}
	

}
