package com.learn.moviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinalCheckMovieCruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalCheckMovieCruiserApplication.class, args);
	}

}
