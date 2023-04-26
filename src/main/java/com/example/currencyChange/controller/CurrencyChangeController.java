package com.example.currencyChange.controller;

import com.example.currencyChange.reference.BaseCurrency;
import com.example.currencyChange.reference.TargetCurrency;
import com.example.currencyChange.service.CurrencyChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "api/change")
public class CurrencyChangeController {

    private final CurrencyChangeService currencyChangeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyChangeController.class);

    @Autowired
    public CurrencyChangeController(CurrencyChangeService currencyChangeService) {
        this.currencyChangeService = currencyChangeService;
    }

    //http://localhost:8080/api/change/?baseCurrency=USD&targetCurrency=MXN&amount=1
    @GetMapping(path = "/")
    public StringBuilder exchange(@RequestParam BaseCurrency baseCurrency,
                           @RequestParam TargetCurrency targetCurrency,
                           @RequestParam BigDecimal amount){

        LOGGER.info("This is an app that only converts the value of an USD currency into" +
                "any other currency specified in the TargetCurrency file.");
        LOGGER.warn("Please check carefully that you insert the correct params at your API Platform");

        return currencyChangeService.url(baseCurrency,targetCurrency,amount);

    }


}
