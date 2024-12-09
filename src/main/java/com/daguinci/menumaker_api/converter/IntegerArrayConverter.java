package com.daguinci.menumaker_api.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class IntegerArrayConverter implements AttributeConverter<Integer[], String> {

    @Override
    public String convertToDatabaseColumn(Integer[] attribute) {
        if (attribute == null) {
            return null;
        }
        return Arrays.toString(attribute)
                     .replace("[", "")
                     .replace("]", "")
                     .replace(" ", "");
    }

    @Override
    public Integer[] convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new Integer[0];
        }
        return Arrays.stream(dbData.split(","))
                     .map(Integer::valueOf)
                     .toArray(Integer[]::new);
    }
}