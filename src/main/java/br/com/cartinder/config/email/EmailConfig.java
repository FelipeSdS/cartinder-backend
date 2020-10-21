package br.com.cartinder.config.email;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.cartinder.config.properties.PropertiesEmail;

@Configuration
public class EmailConfig {
		
	@Bean
	public JavaMailSender getJavaMailSender(PropertiesEmail propertiesEmail) {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername(propertiesEmail.getUsername());
	    mailSender.setPassword(propertiesEmail.getPassword());
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.socketFactory.fallback","true");
	    props.put("mail.smtp.socketFactory.port", "587");
	    props.put("mail.smtp.starttls.required","true");
	    props.put("mail.smtp.ssl.enable", "false");
	    return mailSender;
	}
}