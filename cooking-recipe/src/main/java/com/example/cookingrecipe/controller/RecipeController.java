package com.example.cookingrecipe.controller;

import com.example.cookingrecipe.exception.ResourceNotFoundException;
import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

	@Autowired
	RecipeRepository reciperepository;

	@GetMapping("/recipe")
	public List<Recipe> getAllRecipe() {
		return reciperepository.findAll();
	}
	
	@PostMapping("/recipe")
	public Recipe createRecipe(@Valid Recipe recipe) {
		return reciperepository.save(recipe);
	}

	@GetMapping("/recipe/{id}")
	public Recipe getRecipeById(@PathVariable(value = "id") Long recipeId) {
		return reciperepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
	}

	@PutMapping("/recipe/{id}")
	public Recipe updateRecipe(@PathVariable(value = "id") Long recipeId, @Valid @RequestBody Recipe recipeDetails) {

		Recipe recipe = reciperepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));

		recipe.setTitle(recipeDetails.getTitle());
		recipe.setServingsize(recipeDetails.getServingsize());
		recipe.setIndicator(recipeDetails.getIndicator());
		recipe.setCookingins(recipeDetails.getCookingins());
		recipe.setIngredients(recipeDetails.getIngredients());
		recipe.setUrl(recipeDetails.getUrl());

		Recipe updatedRecipe = reciperepository.save(recipe);
		return updatedRecipe;
	}

	@DeleteMapping("/recipe/{id}")
	public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") Long recipeId) {
		Recipe recipe = reciperepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));

		reciperepository.delete(recipe);

		return ResponseEntity.ok().build();
	}

}
