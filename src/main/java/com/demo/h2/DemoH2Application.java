package com.demo.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoH2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoH2Application.class, args);
	}

}
