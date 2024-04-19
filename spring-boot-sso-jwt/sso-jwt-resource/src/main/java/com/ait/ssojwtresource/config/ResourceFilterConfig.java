package com.ait.ssojwtresource.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created by STS
 * Project : sso-jwt
 * @author aloke d.
 * @version 1.0
 * Email: alokebd@gmail.com
 */
@Configuration
public class ResourceFilterConfig {
	//@Value("${services.auth}") // NOTE -- as it might be caching issue and this value is reading by Spring container. 
	//private String authService="http://localhost:8080/login";
	
	@Autowired
	private JwtFilter JwtFilter;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(JwtFilter);
		registrationBean.setInitParameters(Collections.singletonMap("services.auth", JwtFilter.getAuthServic()));
		registrationBean.addUrlPatterns("/protected-resource");

		return registrationBean;
	}
	

}
