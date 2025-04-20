package ru.job4j.security;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class AuthApp {

	@Bean
	public SpringLiquibase liquibase(DataSource ds) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:db.changelog/liquibase-changeLog.xml");
		liquibase.setDataSource(ds);
		return liquibase;
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthApp.class, args);
        System.out.println("Go to http://localhost:8080/welcome");
	}

}
