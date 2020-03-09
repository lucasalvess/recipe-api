package com.recipe.recipeapi.models;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="TB_RECIPE")
public class Recipe extends AbstractModel implements Serializable{
	
	private static final long serialVersionUID = -7169638148702718527L;
	
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

}
