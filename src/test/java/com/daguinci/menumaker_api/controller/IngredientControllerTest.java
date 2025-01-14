package com.daguinci.menumaker_api.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.daguinci.menumaker_api.repository.IngredientRepository;

@ExtendWith(MockitoExtension.class)
public class IngredientControllerTest {

    @Mock private IngredientRepository ingredientRepository;
    private IngredientController underTest;

    @BeforeEach
    void setUp() {
        underTest = new IngredientController(ingredientRepository);
    }

    @Test
    @Disabled
    void testAddIngredient() {

    }

    @Test
    void canGetAllIngredients() {
        // when
        underTest.getAllIngredients();

        // then
        verify(ingredientRepository).findAll();
    }
}
