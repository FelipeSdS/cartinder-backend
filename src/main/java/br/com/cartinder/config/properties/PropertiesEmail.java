package br.com.cartinder.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties("cartinder.email")
public class PropertiesEmail {
	
	private String key;
	
	private String username;
	
	private String password;
}