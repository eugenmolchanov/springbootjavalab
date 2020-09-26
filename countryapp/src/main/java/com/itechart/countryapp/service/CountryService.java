package com.itechart.countryapp.service;

import com.itechart.countryapp.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> neighbours(Country country);

    void showNeighbours(Country country);
}
