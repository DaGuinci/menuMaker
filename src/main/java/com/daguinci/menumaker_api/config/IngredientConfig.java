package com.daguinci.menumaker_api.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.daguinci.menumaker_api.Ingredient.Ingredient;
import com.daguinci.menumaker_api.Ingredient.IngredientRepository;

@Configuration
public class IngredientConfig {

    @Bean
    CommandLineRunner commandLineRunner(
        IngredientRepository ingredientRepository) {
        return args -> {
            Ingredient potato = new Ingredient(
                "Potato",
                "Vegetable",
                false,
                new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
            );

            Ingredient tomato = new Ingredient(
                "Tomato",
                "Fruit",
                true,
                new Integer[]{6, 7, 8, 9}
            );

            ingredientRepository.saveAll(
                List.of(potato, tomato)
            );
        };
    };
}