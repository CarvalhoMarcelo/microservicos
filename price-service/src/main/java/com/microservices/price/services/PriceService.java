package com.microservices.price.services;

import com.microservices.price.models.Price;

public interface PriceService {

    public Price getPriceInfo(Long id);

}
