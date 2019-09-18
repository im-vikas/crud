package com.example.cookingrecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cookingrecipe.exception.ResourceNotFoundException;
import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.repository.RecipeRepository;
@Service
public class RecipeService {
	
	private static final String RECIPE = "Recipe";
	
	@Autowired
	RecipeRepository reciperepository;
	
	public List<Recipe> allRecipe() {
		return reciperepository.findAll();
	}
	
	public Recipe saveRecipe(Recipe recipe) {
		return reciperepository.save(recipe);
	}
	
	public Recipe getById(Long recipeId) {
		return reciperepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException(RECIPE, "id", recipeId));
	}
	
	public Recipe uRecipe(Long recipeId,Recipe recipeDetails) {

		Recipe recipe = reciperepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException(RECIPE, "id", recipeId));

		recipe.setTitle(recipeDetails.getTitle());
		recipe.setServingsize(recipeDetails.getServingsize());
		recipe.setIndicator(recipeDetails.getIndicator());
		recipe.setCookingins(recipeDetails.getCookingins());
		recipe.setIngredients(recipeDetails.getIngredients());
		recipe.setUrl(recipeDetails.getUrl());

		
		return reciperepository.save(recipe);
	}
	
	
	public void dRecipe(Long recipeId) {
		Recipe recipe = reciperepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException(RECIPE, "id", recipeId));

		reciperepository.delete(recipe);
	}

}
