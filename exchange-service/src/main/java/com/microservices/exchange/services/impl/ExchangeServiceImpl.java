package com.microservices.exchange.services.impl;

import com.microservices.exchange.enums.Currencies;
import com.microservices.exchange.models.ExgVal;
import com.microservices.exchange.services.ExchangeService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Override
    public ExgVal getExgVal(String from, String to) {

        ExgVal exgVal;

        if(Currencies.USD.toString().equals(from) && Currencies.INR.toString().equals(to)) {
            return exgVal = new ExgVal(901L, Currencies.USD, Currencies.INR, 60);
        } else if (Currencies.USD.toString().equals(from) && Currencies.YEN.toString().equals(to)) {
            return exgVal = new ExgVal(901L, Currencies.USD ,Currencies.YEN, 105);
        }

        return null;
    }
}
