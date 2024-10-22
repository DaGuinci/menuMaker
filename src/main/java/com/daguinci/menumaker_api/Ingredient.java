package com.daguinci.menumaker_api;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.daguinci.menumaker_api.converter.IntegerArrayConverter;


@Entity // This tells Hibernate to make a table out of this class
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String type;

    private Boolean seasonal;

    @Convert(converter = IntegerArrayConverter.class)
    private Integer[] seasons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSeasonal() {
        return seasonal;
    }

    public void setSeasonal(Boolean seasonal) {
        this.seasonal = seasonal;
    }

    public Integer[] getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer[] seasons) {
        this.seasons = seasons;
    }
}
