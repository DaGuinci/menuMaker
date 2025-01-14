package com.daguinci.menumaker_api.Ingredient;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        Ingredient ingredient = new Ingredient(
            "Cucumber",
            "Vegetable",
            true,
            new Integer[] { 1, 2, 3 }
        );
        underTest.addIngredient(ingredient);
        // underTest.addIngredient(
        //     "Cucumber",
        //     "Vegetable",
        //     true,
        //     new Integer[] { 1, 2, 3 }
        // );

        // then
        ArgumentCaptor<Ingredient> ingredientArgumentCaptor =
            ArgumentCaptor.forClass(Ingredient.class);
        
        verify(ingredientRepository).save(ingredientArgumentCaptor.capture());

        // Ingredient capturedIngredient = ingredientArgumentCaptor.getValue();
        // assertThat(capturedIngredient).isEqualTo(ingredient);
    }

    @Test
    void canGetAllIngredients() {
        // when
        underTest.getAllIngredients();

        // then
        verify(ingredientRepository).findAll();
    }
}
