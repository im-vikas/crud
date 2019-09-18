/**
 * 
 */
package com.example.cookingrecipe.serviceimpl;

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
import static org.mockito.Mockito.when;

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
		
		
		List<Recipe> list = new ArrayList<>();
        Recipe recipe1 = new Recipe("test", "test", "test", "test", "test", "test");
        Recipe recipe2 = new Recipe("test1", "test2", "test3", "test4", "test5", "test6");	
        list.add(recipe1);
        list.add(recipe2);
        
        when(reciperepository.findAll()).thenReturn(list);

        List<Recipe> allRecipe = recipeService.allRecipe();
        assertEquals(list.size(), allRecipe.size());

	}
	
	
	@Test
	public void testgetById() {
		Recipe recipe = new Recipe("test", "test", "test", "test", "test", "test");
		Optional<Recipe> orecipe = Optional.of(recipe);
		
		when(reciperepository.findById(1L)).thenReturn(orecipe);
		Recipe recipe1 = recipeService.getById(1L);
		assertEquals(orecipe.get(),recipe1);
	}
	
	
	@Test
	public void testuRecipe() {
		Recipe recipe = new Recipe("test", "test", "test", "test", "test", "test");
		Optional<Recipe> orecipe = Optional.of(recipe);
		when(reciperepository.findById(1L)).thenReturn(orecipe);
		Recipe updatedRecipe = new Recipe("updated test", "test", "test", "test", "test", "test"); 
		when(reciperepository.save(recipe)).thenReturn(updatedRecipe);
		
		Recipe serviceRecipe = recipeService.uRecipe(1L, updatedRecipe);
		
		assertEquals(updatedRecipe, serviceRecipe);
	}
	
	@Test
	public void testdRecipe() {
		Recipe recipe = new Recipe("test", "test", "test", "test", "test", "test");
		reciperepository.delete(recipe);
		verify(reciperepository, times(1)).delete(recipe);
		
	}

	
	

}
