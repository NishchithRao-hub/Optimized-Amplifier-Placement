package com.capgemini.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")

@SpringBootApplication
public class NodeApplication {
	public static void main(String[] args) {
		SpringApplication.run(NodeApplication.class, args);
	}

}
