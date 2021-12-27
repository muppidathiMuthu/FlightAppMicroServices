package com.flyhigh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightinventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightinventoryApplication.class, args);
	}

}
