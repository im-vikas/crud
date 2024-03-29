package com.example.cookingrecipe.controller;

import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeservice;
	
	@GetMapping("/api/recipe")
	public List<Recipe> getAllRecipe() {
		return recipeservice.allRecipe();
	}
	
	@PostMapping(value="/api/recipe",consumes = "application/json")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return recipeservice.saveRecipe(recipe);
	}

	@GetMapping("/api/recipe/{id}")
	public Recipe getRecipeById(@PathVariable(value = "id") Long recipeId) {
		return recipeservice.getById(recipeId);
	}

	@PutMapping("/api/recipe/{id}")
	public Recipe updateRecipe(@PathVariable(value = "id") Long recipeId, @Valid @RequestBody Recipe recipeDetails) {
		return recipeservice.uRecipe(recipeId, recipeDetails);
	}

	@DeleteMapping("/api/recipe/{id}")
	public void deleteRecipe(@PathVariable(value = "id") Long recipeId) {
		 recipeservice.dRecipe(recipeId);
	}

}
