package com.example.cookingrecipe.controller;

import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@ComponentScan(basePackages = "com.*")
public class RecipeController {

	@Autowired
	RecipeService recipeservice;
	
	/*@RequestMapping("/")
	public String Page() {
		return "recipe";
		
	}*/

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
