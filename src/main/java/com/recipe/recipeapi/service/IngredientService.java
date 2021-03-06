package com.recipe.recipeapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.exception.NotFoundException;
import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.dto.IngredientDTO;
import com.recipe.recipeapi.repository.IngredientRepository;
import com.recipe.recipeapi.utils.ConvertListUtils;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;

	private static final String UUID_NOT_FOUND = "UUID not found!";	
	
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
			return ConvertListUtils.convertIngredientToDtoList(ingredientRepository.findAll());
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

	public IngredientDTO updateIngredient(Ingredient ingredientForm) {
		try {
			Ingredient ingredient = ingredientRepository.findByUuid(ingredientForm.getUuid());
			ingredient.setName(ingredientForm.getName());
			return new IngredientDTO(ingredientRepository.save(ingredient));
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

}
