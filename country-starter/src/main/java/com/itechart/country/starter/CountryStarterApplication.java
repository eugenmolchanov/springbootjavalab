package com.itechart.country.starter;

import com.itechart.countryapp.service.CountryService;
import com.itechart.countryapp.service.impl.CountryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CountryStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryStarterApplication.class, args);
    }

    @Bean
    public CountryService countryService() {
        throw new RuntimeException("hey");
    }
}
