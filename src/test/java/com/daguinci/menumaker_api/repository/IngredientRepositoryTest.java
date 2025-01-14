package com.daguinci.menumaker_api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.daguinci.menumaker_api.model.Ingredient;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfIngredientNameExists() {
        // given
        String name = "Cucumber";
        Ingredient ingredient = new Ingredient(
            name,
            "Vegetable",
            true,
            new Integer[] { 1, 2, 3 }
        );
        underTest.save(ingredient);

        // when
        boolean expected = underTest.existsByName(name);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckIfIngredientNameDoesNotExist() {
        // given
        String name = "Cucumber";

        // when
        boolean expected = underTest.existsByName(name);

        // then
        assertThat(expected).isFalse();
    }
}
