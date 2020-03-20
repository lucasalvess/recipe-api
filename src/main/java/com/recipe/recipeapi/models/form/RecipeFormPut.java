package com.recipe.recipeapi.models.form;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.Locale.Category;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.models.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeFormPut implements Serializable{

	private static final long serialVersionUID = -7169638148702718527L;

	@ApiModelProperty(example = "16b4a536-55fc-4997-b6c8-38001098d44b")
	@NotNull(message = "{recipe.form.uuid.is.null}")
	private UUID uuid;
	
	@ApiModelProperty(example = "Uma receita qualquer", value = "Nome completo da receita")
	@NotEmpty(message = "{recipe.form.name.is.empty}")
	private String name;

	@ApiModelProperty(example = "Receita feita a partir desses ingredientes", value = "Descrição")
	private String description;

	@ApiModelProperty(example = "Sobremesas")
	@NotNull(message = "{recipe.form.category.is.null}")
	private Category category;

	private String stepBystep;

	@ApiModelProperty(example = "60", value = "Tempo em minutos")
	private int time;

	@Valid
	@NotNull(message = "{recipe.form.ingredients.is.empty}")
	private List<Ingredient> ingredients;

	@Valid
	@NotNull(message = "{recipe.form.user.is.empty}")
	private User chef;

	public Recipe convertToEntity() {
		return Recipe.builder()
				.uuid(uuid)
				.name(name)
				.description(description)
				.category(category)
				.stepBystep(stepBystep)
				.time(time)
				.ingredients(ingredients)
				.chef(chef)
				.build();
	}
}
