package com.itechart.countryapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Country {

    public Country(String name) {
        this.name = name;
    }

    private String name;
    private double population;
}
