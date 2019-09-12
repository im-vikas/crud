/**
 * 
 */
package com.example.cookingrecipe.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		Recipe recipe = new Recipe("Recipe","2","veg", "Cook it well","cook", "url");

		when(reciperepository.save(recipe)).thenReturn(recipe);

		Recipe searchRecipe = recipeService.saveRecipe(recipe);
		assertEquals(recipe.getTitle(), searchRecipe.getTitle());
		assertEquals(recipe.getCookingins(), searchRecipe.getCookingins());
		assertEquals(recipe.getIndicator(), searchRecipe.getIndicator());
		assertEquals(recipe.getServingsize(), searchRecipe.getServingsize());
		assertEquals(recipe.getUrl(), searchRecipe.getUrl());

	}
	
	@Test
	public void testallRecipe() {
		
		
		List<Recipe> list = new ArrayList<Recipe>();
        Recipe recipe1 = new Recipe("test", "test", "test", "test", "test", "test");
        Recipe recipe2 = new Recipe("test1", "test1", "test1", "test1", "test1", "test1");	
        list.add(recipe1);
        list.add(recipe2);
        
        when(reciperepository.findAll()).thenReturn(list);

        List<Recipe> allRecipe = recipeService.allRecipe();
        assertEquals(list.size(), allRecipe.size());

	}
	
	/*
	 * @Test public void testallRecipe() { Optional<Recipe> recipe =
	 * Optional.empty();
	 * 
	 * when(reciperepository.findById(1L)).thenReturn(recipe);
	 * 
	 * Recipe searchRecipe = recipeService.getById(1L);
	 * 
	 * assertEquals(recipe.get(), searchRecipe.); }
	 */

}
