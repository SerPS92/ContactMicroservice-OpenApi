package com.example.ContactMicroserviceOpenApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class ContactMicroserviceOpenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactMicroserviceOpenApiApplication.class, args);
		System.out.println(SpringVersion.getVersion());
		System.out.println("http://localhost:8080/swagger-ui.html");
	}

}
