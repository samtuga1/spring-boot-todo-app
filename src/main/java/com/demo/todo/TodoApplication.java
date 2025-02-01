package com.demo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		// new AnnotationConfigApplicationContext(AppContext.class);
		SpringApplication.run(TodoApplication.class, args);
	}

}
