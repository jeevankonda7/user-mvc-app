package org.olympus.usermvcapp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.olympus.usermvcapp")
public class MyUserConfig {

	@Bean
	public Session getSession() {
		return new org.hibernate.cfg.Configuration().configure().buildSessionFactory().openSession();
	}
	
	
}
