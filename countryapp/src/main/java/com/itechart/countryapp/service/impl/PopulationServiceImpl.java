package com.itechart.countryapp.service.impl;

import com.itechart.countryapp.service.PopulationService;

public class PopulationServiceImpl implements PopulationService {

    private final double MEDIUM = 20_000_000;

    @Override
    public double getPopulationByCountryId(int id) {
        return withFluctuation(getPopulation(id));
    }

    private int getPopulation(int id) {
        switch (id) {
            case 1:
                return 9_449_323;
            case 2:
                return 145_934_462;
            case 3:
                return 43_733_762;
            case 4:
                return 37_846_611;
            case 5:
                return 2_722_289;
            case 6:
                return 1_886_198;
            case 7:
                return 1_326_535;
            case 8:
                return 83_783_942;
            case 9:
                return 10_708_981;
            default:
                return 0;
        }
    }

    private int withFluctuation(int population) {
        return (int) ((Math.random() * 10000) * (population / MEDIUM)) + population;
    }
}
