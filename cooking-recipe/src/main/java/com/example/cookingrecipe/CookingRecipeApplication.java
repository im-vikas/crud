package com.example.cookingrecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CookingRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookingRecipeApplication.class, args);
	}

}
