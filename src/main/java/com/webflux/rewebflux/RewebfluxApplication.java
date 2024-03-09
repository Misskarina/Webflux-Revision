package com.webflux.rewebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableR2dbcRepositories
@EnableWebFlux
@SpringBootApplication
public class RewebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewebfluxApplication.class, args);
	}

}
