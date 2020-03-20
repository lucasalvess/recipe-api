package com.recipe.recipeapi.utils;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.models.dto.IngredientDTO;
import com.recipe.recipeapi.models.dto.RecipeDTO;
import com.recipe.recipeapi.models.dto.UserDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertListUtils {
	
	public List<UserDTO> convertUserToDtoList(List<User> userList){
		List<UserDTO> listDTO = new ArrayList<UserDTO>();

		userList.forEach(i -> listDTO.add(new UserDTO(i)));
		return listDTO;
	}
	
	public List<IngredientDTO> convertIngredientToDtoList(List<Ingredient> ingredientList){
		List<IngredientDTO> listDTO = new ArrayList<IngredientDTO>();

		ingredientList.forEach(i -> listDTO.add(new IngredientDTO(i)));
		return listDTO;
	}
	
	public List<RecipeDTO> convertRecipeToDtoList(List<Recipe> recipeList){
		List<RecipeDTO> listDTO = new ArrayList<RecipeDTO>();

		recipeList.forEach(r -> listDTO.add(new RecipeDTO(r)));
		return listDTO;
	}
}
