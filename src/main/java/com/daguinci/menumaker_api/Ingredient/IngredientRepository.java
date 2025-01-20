package com.daguinci.menumaker_api.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    boolean existsByName(String name);
}