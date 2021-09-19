package com.microservices.price.services.impl;

import com.microservices.price.models.ExgVal;
import com.microservices.price.models.Price;
import com.microservices.price.repositories.PriceMockRepository;
import com.microservices.price.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceMockRepository priceMockRepository;

    @Autowired
    RestTemplate restTemplate;

    final static String USD = "USD";
    final static String YEN = "YEN";

    @Override
    public Price getPriceInfo(Long id) {

        Price price = priceMockRepository.getPriceInfo(id);

        try {
            if(price != null)
                price.setDiscountedPrice(Math.multiplyExact(Objects.requireNonNull(getExgVal(USD,YEN), "Error retrieving Exchange value!"), price.getDiscountedPrice()));
        } catch (NullPointerException e) {
            Logger.getLogger(e.getMessage());
            throw new NullPointerException(e.getMessage());
        }

        return price;
    }

    private Integer getExgVal(String from, String to){

        Integer exgVal = 1;

        try{
            return restTemplate.getForObject("http://localhost:8004/currexg/from/" + from + "/to/" + to, ExgVal.class).getExgVal();
        } catch (Exception e){
            Logger.getLogger(e.getMessage());
            return null;
        }

    }





}
