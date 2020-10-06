package com.itechart.javalab.springbootapp;

import com.itechart.countryapp.model.Country;
import com.itechart.countryapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> countries(@RequestParam("country") String country) {
        return countryService.neighbours(new Country(country));
    }
}
