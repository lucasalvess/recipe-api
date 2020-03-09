package com.recipe.recipeapi.models.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO implements Serializable{
	
	private static final long serialVersionUID = -7169638148702718527L;
	
	private UUID uuid;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	private String stepBystep;
	
	private int time;
	
	@OneToMany
	private List<Ingredient> ingredients;
	
	@OneToOne
	private User chef;
	
	public RecipeDTO(Recipe recipe) {
		this.uuid = recipe.getUuid();
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.category = recipe.getCategory();
		this.stepBystep = recipe.getStepBystep();
		this.time = recipe.getTime();
		this.ingredients = recipe.getIngredients();
		this.chef = recipe.getChef();
	}
	
	public List<RecipeDTO> convertAList(List<Recipe> recipeList){
		List<RecipeDTO> listDTO = new ArrayList<RecipeDTO>();

		recipeList.forEach(r -> listDTO.add(new RecipeDTO(r)));
		return listDTO;
	}

}
