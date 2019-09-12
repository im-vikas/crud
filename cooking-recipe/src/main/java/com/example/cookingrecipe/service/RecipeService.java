package com.example.cookingrecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cookingrecipe.exception.ResourceNotFoundException;
import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.repository.RecipeRepository;
@Service
public class RecipeService {
	
	@Autowired
	RecipeRepository reciperepository;
	
	public List<Recipe> allRecipe() {
		return reciperepository.findAll();
	}
	
	public Recipe saveRecipe(Recipe recipe) {
		return reciperepository.save(recipe);
	}
	
	public Recipe getById(Long recipeId) {
		return reciperepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));
	}
	
	public Recipe uRecipe(Long recipeId,Recipe recipeDetails) {

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
	
	
	public void dRecipe(Long recipeId) {
		Recipe recipe = reciperepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", recipeId));

		reciperepository.delete(recipe);
	}

}
