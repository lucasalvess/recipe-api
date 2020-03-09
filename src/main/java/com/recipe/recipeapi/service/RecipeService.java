package com.recipe.recipeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;

	public List<Recipe> findAllRecipes() {
		return recipeRepository.findAll();
	}

}
