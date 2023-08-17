package br.com.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	CommandLineRunner criarTarefaFake(TodoRepository todorepository) {
		return args -> {
			todorepository.deleteAll();
			Todo todo1 = new Todo("Configurar JDK", "Preciso  aprender a configurar o jdk corretamente", StatusEnum.NOT_STARTED);
			Todo todo2 = new Todo("Estudar Java", "Estudar Java para aprender programação", StatusEnum.IN_PROGRESS);
			Todo todo3 = new Todo("Estudar HTML","Estudar html para desenvolver site", StatusEnum.FINISHED);

			todorepository.save(todo1);
			todorepository.save(todo2);
			todorepository.save(todo3);
		};

	}
}