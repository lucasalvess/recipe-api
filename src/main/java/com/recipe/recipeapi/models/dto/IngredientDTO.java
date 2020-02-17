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
	private String nome;
	
	public IngredientDTO(Ingredient ingredient) {
		this.uuid = ingredient.getUuid();
		this.nome = ingredient.getNome();
	}
	
	public IngredientDTO converter(Ingredient ingredient) {
		
		return builder()
				.nome(ingredient.getNome())
				.uuid(ingredient.getUuid()).build();
	}
}
