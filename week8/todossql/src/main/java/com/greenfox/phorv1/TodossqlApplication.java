package com.greenfox.phorv1;

import com.greenfox.phorv1.model.Todo;
import com.greenfox.phorv1.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodossqlApplication implements CommandLineRunner{

	@Autowired
	TodoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TodossqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
