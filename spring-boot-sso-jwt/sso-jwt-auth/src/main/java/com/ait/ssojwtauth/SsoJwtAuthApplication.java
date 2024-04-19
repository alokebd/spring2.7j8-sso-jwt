package com.ait.ssojwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by STS
 * Project : sso-jwt
 * @author aloke d.
 * @version 1.0
 * Email: alokebd@gmail.com
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
