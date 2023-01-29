package com.api.eventos_sociales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.api.eventos_sociales.model.StorageProperties;
import com.api.eventos_sociales.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EventosSocialesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventosSocialesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			// storageService.deleteAll();
			storageService.init();
		};
	}
}
