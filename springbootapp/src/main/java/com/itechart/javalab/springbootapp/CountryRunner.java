package com.itechart.javalab.springbootapp;

import com.itechart.countryapp.model.Country;
import com.itechart.countryapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryRunner implements CommandLineRunner {

    private final CountryService countryService;

    public CountryRunner(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {
        countryService.showNeighbours(new Country("Belarus"));
    }
}
