package com.microservices.price.repositories;

import com.microservices.price.models.Price;

import java.util.List;

public interface PriceMockRepository {

    public List<Price> createMock();

    public Price getPriceInfo(Long id);

}
