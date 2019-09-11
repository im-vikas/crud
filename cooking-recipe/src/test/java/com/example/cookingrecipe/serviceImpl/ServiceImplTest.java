/**
 * 
 */
package com.example.cookingrecipe.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cookingrecipe.model.Recipe;
import com.example.cookingrecipe.repository.RecipeRepository;
import com.example.cookingrecipe.service.RecipeService;

/**
 * @author C67708
 *
 */
@SpringBootTest
public class ServiceImplTest {

	@Mock
	RecipeRepository reciperepository;

	@InjectMocks
	RecipeService recipeService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveRecipe() {
		Recipe recipe = new Recipe();
		recipe.setTitle("Recipe");
		recipe.setCookingins("Cook it well");
		recipe.setIndicator("veg");
		recipe.setServingsize("2");
		recipe.setUrl("url");

		when(reciperepository.save(recipe)).thenReturn(recipe);

		Recipe searchRecipe = recipeService.saveRecipe(recipe);
		assertEquals(recipe.getTitle(), searchRecipe.getTitle());
		assertEquals(recipe.getCookingins(), searchRecipe.getCookingins());
		assertEquals(recipe.getIndicator(), searchRecipe.getIndicator());
		assertEquals(recipe.getServingsize(), searchRecipe.getServingsize());
		assertEquals(recipe.getUrl(), searchRecipe.getUrl());

	}

}
