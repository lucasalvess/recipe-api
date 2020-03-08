package com.recipe.recipeapi.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted = 0")
@Table(name = "TB_INGREDIENT")
public class Ingredient extends AbstractModel implements Serializable{

	private static final long serialVersionUID = -7169638148702718527L;

	@Builder.Default
	@EqualsAndHashCode.Include
	@Type(type = "uuid-char")
	@Column(nullable = false)
	private UUID uuid = UUID.randomUUID();
	
	@Column(nullable = false)
	private String name;
}
