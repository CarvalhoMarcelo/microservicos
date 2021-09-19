package com.microservices.inventory.controllers;

import com.microservices.inventory.models.Inventory;
import com.microservices.inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

	@Autowired
    InventoryService inventoryService;

	@GetMapping("/inventory/{productID}")
	public Inventory getInventoryDetails(@PathVariable Long productID) {
		
		return inventoryService.getInventoryInfo(productID);
		
	}

}
