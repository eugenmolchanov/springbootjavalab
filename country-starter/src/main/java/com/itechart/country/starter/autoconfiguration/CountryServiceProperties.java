package com.itechart.country.starter.autoconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("country")
@Data
public class CountryServiceProperties {

    /**
     * Add population to country details
     */
    private boolean showPopulation = true;
}
