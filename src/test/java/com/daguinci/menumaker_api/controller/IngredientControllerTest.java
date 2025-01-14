package com.daguinci.menumaker_api.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.daguinci.menumaker_api.Ingredient.Ingredient;
import com.daguinci.menumaker_api.Ingredient.IngredientController;
import com.daguinci.menumaker_api.Ingredient.IngredientRepository;

@ExtendWith(MockitoExtension.class)
public class IngredientControllerTest {

    @Mock private IngredientRepository ingredientRepository;
    private IngredientController underTest;

    @BeforeEach
    void setUp() {
        underTest = new IngredientController(ingredientRepository);
    }

    @Test
    void canAddAnIngredient() {
        // repository is already tested, so we can mock it
        // the save method is already tested in the repository test
        // so we can just verify that it was called
        // and that the correct arguments were passed
        

        // when
        underTest.addIngredient(
            "Cucumber",
            "Vegetable",
            true,
            new Integer[] { 1, 2, 3 }
        );

        // then
        ArgumentCaptor<Ingredient> ingredientArgumentCaptor =
            ArgumentCaptor.forClass(Ingredient.class);

    }

    @Test
    void canGetAllIngredients() {
        // when
        underTest.getAllIngredients();

        // then
        verify(ingredientRepository).findAll();
    }
}
