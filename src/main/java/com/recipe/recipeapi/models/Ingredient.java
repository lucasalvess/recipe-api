package com.recipe.recipeapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "TB_INGREDIENT")
public class Ingredient extends Abstract implements Serializable{

	private static final long serialVersionUID = -7169638148702718527L;

	@Column(nullable = false)
	private String nome;
}
