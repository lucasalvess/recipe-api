package com.recipe.recipeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.models.dto.RecipeDTO;
import com.recipe.recipeapi.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	private static final RecipeDTO recipeDTO = new RecipeDTO();

	public List<RecipeDTO> findAllRecipes() {
		return recipeDTO.convertAList(recipeRepository.findAll());
	}

}
