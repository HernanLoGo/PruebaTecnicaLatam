package com.logo.pruebalatam.back.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		builder.errorHandler(getErrorHandler());
		return builder.build();
	}
	
//	@Bean
//	public CustomResponseErrorHandler getErrorHandler() {
//	    return new CustomResponseErrorHandler();
//	}
}
