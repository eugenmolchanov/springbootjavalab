package com.itechart.javalab.springbootapp;

import com.itechart.countryapp.model.Country;
import com.itechart.countryapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryRunner implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    @Value("${country.name}")
    private String country;

    @Override
    public void run(String... args) throws Exception {
        countryService.showNeighbours(new Country(country));
    }
}
