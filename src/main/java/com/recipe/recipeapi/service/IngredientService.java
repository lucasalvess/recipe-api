package com.recipe.recipeapi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.exception.NotFoundException;
import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.dto.IngredientDTO;
import com.recipe.recipeapi.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	private static final String UUID_NOT_FOUND = "UUID not found!";
	
	private static final IngredientDTO ingredientDTO = new IngredientDTO();
	
	public IngredientDTO createIngredient(Ingredient ingredient) {
		return ingredientDTO.converter(ingredientRepository.save(ingredient));
	}
	
	public IngredientDTO findIngredientByUuid(UUID uuid) {
		try {
			return ingredientDTO.converter(ingredientRepository.findByUuid(uuid));
		} catch (RuntimeException e) {
			throw new NotFoundException(UUID_NOT_FOUND);
		}
	}
	
	
}
