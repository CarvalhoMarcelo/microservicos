package com.microservices.price.repositories.impl;

import com.microservices.price.models.Price;
import com.microservices.price.repositories.PriceMockRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceMockRepositoryImpl implements PriceMockRepository {

    @Override
    public List<Price> createMock() {

        List<Price> priceList = new ArrayList<Price>();

        priceList.add(new Price(201L, 101L, 1999,999));
        priceList.add(new Price(202L, 102L, 999,300));
        priceList.add(new Price(203L, 103L, 600,250));

        return priceList;

    }

    @Override
    public Price getPriceInfo(Long id) {

        List<Price> priceList = createMock();

        for(Price price : priceList) {
            if(id.equals(price.getProductID()))
                return price;
        }

        return null;
    }


}
