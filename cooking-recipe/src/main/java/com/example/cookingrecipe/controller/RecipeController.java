package com.example.cookingrecipe.controller;

import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

	@Autowired
	RecipeService recipeservice;

	@GetMapping("/recipe")
	public List<Recipe> getAllRecipe() {
		return recipeservice.allRecipe();
	}
	
	@PostMapping("/recipe")
	public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
		return recipeservice.saveRecipe(recipe);
	}

	@GetMapping("/recipe/{id}")
	public Recipe getRecipeById(@PathVariable(value = "id") Long recipeId) {
		return recipeservice.getById(recipeId);
	}

	@PutMapping("/recipe/{id}")
	public Recipe updateRecipe(@PathVariable(value = "id") Long recipeId, @Valid @RequestBody Recipe recipeDetails) {
		return recipeservice.uRecipe(recipeId, recipeDetails);
	}

	@DeleteMapping("/recipe/{id}")
	public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") Long recipeId) {
		return recipeservice.dRecipe(recipeId);
	}

}
