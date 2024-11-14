/**
 * The MIT License (MIT)
 * Copyright (c) 2024 Eduardo Junior Pereira Garcia
 * 
 * https://github.com/ejpg-sys/issue-spring-mockmvc
 */
package ejpg.issue.spring.mockmvc;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication boot = new SpringApplication(ApplicationInitializer.class);
        boot.setDefaultProperties(Collections.singletonMap("server.port","33884"));
        boot.run(args);
	}

}
