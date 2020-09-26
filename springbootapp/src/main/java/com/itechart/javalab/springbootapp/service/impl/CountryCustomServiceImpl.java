package com.itechart.javalab.springbootapp.service.impl;

import com.itechart.countryapp.model.Country;
import com.itechart.countryapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CountryCustomServiceImpl implements CountryService {
    @Override
    public List<Country> neighbours(Country country) {
        return Collections.emptyList();
    }

    @Override
    public void showNeighbours(Country country) {
        System.out.println("No such country in the database.");
    }
}
