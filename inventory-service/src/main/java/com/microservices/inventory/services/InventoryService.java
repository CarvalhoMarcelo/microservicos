package com.microservices.inventory.services;

import com.microservices.inventory.models.Inventory;

public interface InventoryService {

    public Inventory getInventoryInfo(Long id);

}
