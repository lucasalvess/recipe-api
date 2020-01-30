package com.recipe.recipeapi.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Abstract implements Serializable {

	private static final long serialVersionUID = -7169638148702718527L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
}
