package com.recipe.recipeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.models.dto.RecipeDTO;
import com.recipe.recipeapi.repository.RecipeRepository;
import com.recipe.recipeapi.utils.ConvertListUtils;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;

	public List<RecipeDTO> findAllRecipes() {
		return ConvertListUtils.convertRecipeToDtoList(recipeRepository.findAll());
	}

}
