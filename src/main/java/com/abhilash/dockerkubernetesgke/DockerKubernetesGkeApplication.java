package com.abhilash.dockerkubernetesgke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerKubernetesGkeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerKubernetesGkeApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String sayHello(){
		
		return "Hello from springboot";
	}
	

}
