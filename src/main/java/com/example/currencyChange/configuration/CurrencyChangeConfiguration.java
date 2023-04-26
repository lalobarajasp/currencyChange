package com.example.currencyChange.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "output.beans")
public class CurrencyChangeConfiguration {
    private boolean names;
    private String key;
}
