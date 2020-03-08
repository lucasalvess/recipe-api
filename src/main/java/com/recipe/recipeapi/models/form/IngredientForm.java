package com.recipe.recipeapi.models.form;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.recipe.recipeapi.models.Ingredient;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientForm implements Serializable{
	
	private static final long serialVersionUID = 9035680103624403643L;
	
	@ApiModelProperty(example = "Tomato")
	@NotEmpty(message = "ingredient.form.name.is.empty")
	private String name;
	
	public Ingredient convertToEntity() {
		return Ingredient.builder().name(name).build();
	}

}
