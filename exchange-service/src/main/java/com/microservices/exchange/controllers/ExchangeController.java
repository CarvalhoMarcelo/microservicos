package com.microservices.exchange.controllers;

import com.microservices.exchange.models.ExgVal;
import com.microservices.exchange.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

	@Autowired
	ExchangeService exchangeService;

	@GetMapping("/currexg/from/{from}/to/{to}")
	public ExgVal getInventoryDetails(@PathVariable("from") String from, @PathVariable("to") String to) {
		
		return exchangeService.getExgVal(from, to);
		
	}
	
}
