package br.com.kentec.carteiradigital.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {
	
	@Value("${endpoint.front}")
	private String endpoint;
	
	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(endpoint).allowedMethods("GET","POST","PUT","DELETE");
	}
}
