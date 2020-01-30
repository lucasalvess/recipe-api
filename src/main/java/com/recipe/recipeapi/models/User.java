package com.recipe.recipeapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name="TB_USER")
public class User {
	
	private static final long serialVersionUID = -7169638148702718527L;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String password;
}
