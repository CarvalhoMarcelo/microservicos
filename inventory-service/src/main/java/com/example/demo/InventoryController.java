package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	List<Inventory> inventoryList = new ArrayList<Inventory>();
	
	@GetMapping("/inventory/{productID}")
	public Inventory getInventoryDetails(@PathVariable Long productID) {
		
		Inventory inventory = getInventoryInfo(productID);
		
		return inventory;
		
	}
	
	public Inventory getInventoryInfo(Long productID) {
		
		getInventoryList();
		
		for(Inventory inventory : inventoryList) {
			if(productID.equals(inventory.getProductID()))
				return inventory;
		}
		
		return null;
		
	}
	
	
	public void getInventoryList() {
		
		inventoryList.add(new Inventory(301L, 101L, true));
		inventoryList.add(new Inventory(302L, 102L, false));
		inventoryList.add(new Inventory(303L, 103L, true));
		
		
		
		
	}
	

}
