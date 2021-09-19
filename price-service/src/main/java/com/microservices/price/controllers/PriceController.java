package com.microservices.price.controllers;

import com.microservices.price.models.Price;
import com.microservices.price.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

	@Autowired
    PriceService priceService;

	@GetMapping("/price/{productID}")
	public Price getPriceDetails(@PathVariable Long productID) {
		
		return priceService.getPriceInfo(productID);

	}
	
}
