package com.itechart.country.starter.autoconfiguration;

import com.itechart.countryapp.service.CountryService;
import com.itechart.countryapp.service.impl.CountryServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(CountryService.class)
    public CountryService countryService() {
        return new CountryServiceImpl();
    }
}
