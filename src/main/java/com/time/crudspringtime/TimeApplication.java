package com.time.crudspringtime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.time.crudspringtime.model.Time;
import com.time.crudspringtime.repository.TimeRepository;

@SpringBootApplication
public class TimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(TimeRepository timeRepository) 
	{
		return args -> {
			timeRepository.deleteAll();
			Time time = new Time();
			time.setNome("Flamengo");
			time.setEstado("Rio de Janeiro");
			time.setCores("Rubro-negro");
			timeRepository.save(time);
		};
	}

}
