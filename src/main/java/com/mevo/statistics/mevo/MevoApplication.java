package com.mevo.statistics.mevo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class MevoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MevoApplication.class, args);
	}

}
