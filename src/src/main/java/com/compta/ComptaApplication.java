package com.compta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ComptaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComptaApplication.class, args);
	}

	@GetMapping
	public static String index(){
		return "index";
	}

}
