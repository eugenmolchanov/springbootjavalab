package com.itechart.countryapp.service.impl;

import com.itechart.countryapp.model.Country;
import com.itechart.countryapp.service.CountryService;
import com.itechart.countryapp.service.PopulationService;
import lombok.Getter;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryServiceImpl implements CountryService {

    private final PopulationService populationService = new PopulationServiceImpl();
    private final boolean showPopulation;

    public CountryServiceImpl(boolean showPopulation) {
        this.showPopulation = showPopulation;
    }

    @Override
    public List<Country> neighbours(Country country) {
        Optional<CountryDetails> countryDetails = CountryDetails.getCountryDetails(country);

        return countryDetails.map(this::neighbours)
                .orElseGet(Collections::emptyList);
    }

    @Override
    public void showNeighbours(Country country) {
        neighbours(country).forEach(this::printCountryInfo);
    }

    private List<Country> neighbours(CountryDetails countryDetails) {
        return countryDetails.getNeighbours().stream()
                .map(this::country)
                .collect(Collectors.toList());
    }

    private Country country(int id) {
        CountryDetails countryDetails = CountryDetails.getCountryDetailsById(id);
        Country country = new Country();
        country.setName(countryDetails.getName());
        country.setPopulation(populationService.getPopulationByCountryId(id));
        return country;
    }

    private void printCountryInfo(Country country) {
        String details = "Country: " + country.getName();
        if (showPopulation) {
            details = details.concat("; Population: " + customFormat("###,###.### millions", country.getPopulation()));
        }
        System.out.println(details);
    }

    private String customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(value);
    }

    @Getter
    private enum CountryDetails {

        BELARUS(1, "Belarus", List.of(2, 3, 4, 5, 6, 7)),
        RUSSIA(2, "Russia", List.of(1, 3, 5, 7)),
        UKRAINE(3, "Ukraine", List.of(1, 2, 3)),
        POLAND(4, "Poland", List.of(1, 3, 5)),
        LITHUANIA(5, "Lithuania", List.of(1, 2, 4, 6)),
        LATVIA(6, "Latvia", List.of(1, 5, 7)),
        ESTONIA(7, "Estonia", List.of(2, 6)),
        GERMANY(8, "Germany", List.of(4, 9)),
        CZECH_REPUBLIC(9, "Czech Republic", List.of(4, 8));

        private int id;
        private String name;
        private List<Integer> neighbours;

        CountryDetails(int id, String name, List<Integer> neighbours) {
            this.id = id;
            this.name = name;
            this.neighbours = neighbours;
        }

        public static Optional<CountryDetails> getCountryDetails(Country country) {
            return Arrays.stream(CountryDetails.values())
                    .filter(countryDetails -> countryDetails.getName().equalsIgnoreCase(country.getName()))
                    .findFirst();
        }

        public static CountryDetails getCountryDetailsById(int id) {
            return Arrays.stream(CountryDetails.values())
                    .filter(countryDetails -> countryDetails.getId() == id)
                    .findFirst()
                    .get();
        }
    }
}
