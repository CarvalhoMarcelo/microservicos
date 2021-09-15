package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PriceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	List<Price> priceList = new ArrayList<Price>();
	
	@GetMapping("/price/{productID}")
	public Price getPriceDetails(@PathVariable Long productID) {
		
		Price price = getPriceInfo(productID);
		
		Integer exgVal = restTemplate.getForObject("http://localhost:8004/currexg/from/USD/to/YEN", ExgVal.class).getExgVal();
		
		return new Price(price.getPriceID(), price.getProductID(), price.getOriginalPrice(),
				Math.multiplyExact(exgVal, price.getDiscountedPrice()));
		
	}
	
	public Price getPriceInfo(Long productID) {
		
		getPriceList();
		
		for(Price price : priceList) {
			if(productID.equals(price.getProductID()))
				return price;
		}
		
		return null;
		
	}
	
	
	public void getPriceList() {
		
		priceList.add(new Price(201L, 101L, 1999,999));
		priceList.add(new Price(202L, 102L, 999,300));
		priceList.add(new Price(203L, 103L, 600,250));
		
		
		
		
	}
	

}
