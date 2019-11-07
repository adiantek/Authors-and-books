package amu.adiantek.lab05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab05Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab05Application.class, args);
	}

	@Bean
	public String test() {
		return "asdf";
	}
}
