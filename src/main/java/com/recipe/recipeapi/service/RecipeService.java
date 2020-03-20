package com.recipe.recipeapi.service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.exception.NotFoundException;
import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.models.dto.RecipeDTO;
import com.recipe.recipeapi.models.form.RecipeForm;
import com.recipe.recipeapi.models.form.RecipeFormPut;
import com.recipe.recipeapi.repository.RecipeRepository;
import com.recipe.recipeapi.utils.ConvertListUtils;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	private static final String UUID_NOT_FOUND = "UUID not found!";	 

	public List<RecipeDTO> findAllRecipes() {
		return ConvertListUtils.convertRecipeToDtoList(recipeRepository.findAll());
	}
	
	public RecipeDTO findRecipeByUuid(UUID uuid) {
		try {
			return new RecipeDTO(recipeRepository.findByUuid(uuid));
		}catch (Exception e) {
			throw new NotFoundException(UUID_NOT_FOUND);
		}
	}
	
	public RecipeDTO createRecipe(RecipeForm recipeForm) {
		try {
			return new RecipeDTO(recipeRepository.save(recipeForm.convertToEntity()));
		} catch (Exception e) {
			throw new InvalidParameterException();
		}
	}
	
	public boolean deleteRecipeByUuid(UUID uuid) {
		try {
			Recipe recipe = recipeRepository.findByUuid(uuid);
			recipe.setDeleted(true);
			recipeRepository.save(recipe);
			return true;
		} catch (RuntimeException e) {
			throw new NotFoundException(UUID_NOT_FOUND);
		}
	}
	
	public RecipeDTO updateRecipe(RecipeFormPut recipeForm) {
		try {
			Recipe recipe = recipeRepository.findByUuid(recipeForm.getUuid());
			setProperties(recipeForm, recipe);
			return new RecipeDTO(recipe);
		} catch (Exception e) {
			throw new InvalidParameterException();
		}
	}
	
	private void setProperties(RecipeFormPut recipeForm, Recipe recipe) {
		recipe.setName(recipeForm.getName());
		recipe.setDescription(recipeForm.getDescription());
		recipe.setStepBystep(recipeForm.getStepBystep());
		recipe.setCategory(recipeForm.getCategory());
		recipe.setTime(recipeForm.getTime());
		recipe.setChef(recipeForm.getChef());
	}

}
