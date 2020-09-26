package com.itechart.javalab.springbootapp;

import com.itechart.countryapp.model.Country;
import com.itechart.countryapp.service.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootappApplicationTests {

    @Autowired
    private CountryService countryService;

    @Test
    void contextLoads() {
    }

    @Test
    void getCountriesTest() {
        List<Country> countries = countryService.neighbours(new Country("Belarus"));
        Assertions.assertEquals(6, countries.size());
    }

}
