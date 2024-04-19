package com.ait.ssojwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * Aloke Das
 */
@SpringBootApplication
public class SsoJwtAuthApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SsoJwtAuthApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SsoJwtAuthApplication.class, args);
	}
}
