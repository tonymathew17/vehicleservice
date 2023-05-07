package com.service.vehicleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VehicleserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleserviceApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello World!";
	}

}
