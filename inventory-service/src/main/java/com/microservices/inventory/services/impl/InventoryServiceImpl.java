package com.microservices.inventory.services.impl;

import com.microservices.inventory.models.Inventory;
import com.microservices.inventory.repositories.InventoryMockRepository;
import com.microservices.inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMockRepository inventoryMockRepository;

    @Override
    public Inventory getInventoryInfo(Long id) {

        return inventoryMockRepository.getInventoryInfo(id);

    }
}
