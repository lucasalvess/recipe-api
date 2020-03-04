package com.recipe.recipeapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.exception.InvalidParametersException;
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
		return new IngredientDTO(ingredientRepository.save(ingredient));
	}
	
	public IngredientDTO findIngredientByUuid(UUID uuid) {
		try {
			return new IngredientDTO(ingredientRepository.findByUuid(uuid));
		} catch (RuntimeException e) {
			throw new NotFoundException(UUID_NOT_FOUND);
		}
	}

	public List<IngredientDTO> listAllIngredients() {
		try {
			return ingredientDTO.convertAList(ingredientRepository.findAll());
		} catch (RuntimeException e) {
			throw new NotFoundException("Ingredient list Empty");
		}
	}

	public boolean deleteIngredientByUuid(UUID uuid) {
		try {
			Ingredient ingredient = ingredientRepository.findByUuid(uuid);
			ingredient.setDeleted(true);
			ingredientRepository.save(ingredient);
			return true;
		} catch (RuntimeException e) {
			throw new NotFoundException(UUID_NOT_FOUND);
		}
	}

	public IngredientDTO updateIngredient(Ingredient ingredient) {
		try {
			Ingredient ingredientOld =ingredientRepository.findByUuid(ingredient.getUuid());
			ingredientOld = ingredient;
			return new IngredientDTO(ingredientRepository.save(ingredientOld));
		}catch (RuntimeException e) {
			throw new InvalidParametersException("Invalid Ingredient body");
		}
		
	}
	
	
}
