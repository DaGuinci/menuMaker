package com.daguinci.menumaker_api.Ingredient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.daguinci.menumaker_api.Ingredient.exception.BadRequestException;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTest {

    @Mock private IngredientRepository ingredientRepository;
    private IngredientService underTest;

    @BeforeEach
    void setUp() {
        underTest = new IngredientService(ingredientRepository);
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

        // then
        ArgumentCaptor<Ingredient> ingredientArgumentCaptor =
            ArgumentCaptor.forClass(Ingredient.class);
        
        verify(ingredientRepository).save(ingredientArgumentCaptor.capture());

        Ingredient capturedIngredient = ingredientArgumentCaptor.getValue();
        assertThat(capturedIngredient).isEqualTo(ingredient);
    }

    @Test
    void willThrowWhenNameTaken() {
        
        // given
        Ingredient ingredient = new Ingredient(
            "Cucumber",
            "Vegetable",
            true,
            new Integer[] { 1, 2, 3 }
        );

        given(ingredientRepository.existsByName(ingredient.getName()))
        .willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> underTest.addIngredient(ingredient))
            .isInstanceOf(BadRequestException.class)
            .hasMessageContaining("Name " + ingredient.getName() + " taken");

        verify(ingredientRepository, never()).save(any());
    }

    @Test
    @Disabled
    void testDeleteIngredient() {

    }

    @Test
    void canGetAllIngredients() {
        // when
        underTest.getAllIngredients();

        // then
        verify(ingredientRepository).findAll();
    }
}
