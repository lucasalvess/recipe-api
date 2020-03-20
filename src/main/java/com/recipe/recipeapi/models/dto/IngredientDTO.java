package com.recipe.recipeapi.models.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;

import com.recipe.recipeapi.models.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO implements Serializable {

	private static final long serialVersionUID = 9035680108624403643L;
	
	private UUID uuid;
	
	@Column(nullable = false)
	private String name;
	
	public IngredientDTO(Ingredient ingredient) {
		this.uuid = ingredient.getUuid();
		this.name = ingredient.getName();
	}
}
