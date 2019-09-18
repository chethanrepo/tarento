package com.tarento.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.tarento.search.component.DuplicateEntryComponent;

@SpringBootApplication
@EnableRedisRepositories
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	DuplicateEntryComponent duplicateEntryComponent;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	
	
	@Override
	public void run(String... strings) throws Exception {		
		logger.info("Result: " + duplicateEntryComponent.getDuplicateEntry("12345678901234567890"));
	}
	
}
