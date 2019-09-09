package com.example.cookingrecipe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cookingrecipe.model.Recipe;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	

}
