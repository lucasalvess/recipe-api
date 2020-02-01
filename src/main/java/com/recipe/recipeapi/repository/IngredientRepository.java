package com.recipe.recipeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipeapi.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
