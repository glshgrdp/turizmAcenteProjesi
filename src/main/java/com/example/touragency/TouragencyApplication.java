package com.example.touragency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.touragency")
public class TouragencyApplication {
	public static void main(String[] args) {
		SpringApplication.run(TouragencyApplication.class, args);
	}
}
