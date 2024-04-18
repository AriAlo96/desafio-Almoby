package com.almoby.desafio;

import com.almoby.desafio.models.Person;
import com.almoby.desafio.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class,
				args);

	}
//	@Bean
//	public CommandLineRunner initData(PersonRepository personRepository) {
//		return args -> {
//			Person person1 = new Person("Ariana Alochis",
//					"alochisariana@gmail.com",
//					"1234");
//			personRepository.save(person1);
//		};
//	}
}

