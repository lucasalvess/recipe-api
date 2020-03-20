package com.recipe.recipeapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipeapi.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	@Query("SELECT r.id, r.name, r.category, r.description FROM Recipe as r WHERE r.chef.id = ?1")
	public List<Recipe> findByUser(Long id);
	
	public Recipe findByUuid(UUID uuid);
}
