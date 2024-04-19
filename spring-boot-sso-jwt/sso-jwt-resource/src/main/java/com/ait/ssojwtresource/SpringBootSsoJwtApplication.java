package com.ait.ssojwtresource;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootSsoJwtApplication extends SpringBootServletInitializer {
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSsoJwtApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootSsoJwtApplication.class);
	}
	
	@Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            System.out.println("message from application.properties " + environment.getProperty("services.auth"));
        };
    }
	
}
