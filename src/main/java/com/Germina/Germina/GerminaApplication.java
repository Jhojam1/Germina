package com.Germina.Germina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GerminaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerminaApplication.class, args);
	}

}
