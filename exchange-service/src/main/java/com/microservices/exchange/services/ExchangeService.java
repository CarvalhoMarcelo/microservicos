package com.microservices.exchange.services;

import com.microservices.exchange.models.ExgVal;

public interface ExchangeService {

    public ExgVal getExgVal(String from, String to);

}
