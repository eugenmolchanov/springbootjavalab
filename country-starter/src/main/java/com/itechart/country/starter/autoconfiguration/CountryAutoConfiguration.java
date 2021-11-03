package com.itechart.country.starter.autoconfiguration;

import com.itechart.countryapp.service.CountryService;
import com.itechart.countryapp.service.impl.CountryServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CountryServiceProperties.class)
public class CountryAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CountryService countryService(CountryServiceProperties properties) {
        return new CountryServiceImpl(properties.isShowPopulation());
    }
}
