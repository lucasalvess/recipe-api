package com.recipe.recipeapi.models;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_RECIPE")
@Where(clause = "deleted = 0")
public class Recipe extends AbstractModel implements Serializable{
	
	private static final long serialVersionUID = -7169638148702718527L;
	
	@Builder.Default
	@EqualsAndHashCode.Include
	@Type(type = "uuid-char")
	@Column(nullable = false)
	private UUID uuid = UUID.randomUUID();
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	private String stepBystep;
	
	@Positive
	private int time;
	
	@OneToMany
	private List<Ingredient> ingredients;
	
	@OneToOne
	private User chef;	

}
