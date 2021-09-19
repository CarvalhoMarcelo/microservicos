package com.microservices.inventory.repositories;

import com.microservices.inventory.models.Inventory;

import java.util.List;

public interface InventoryMockRepository {

    public List<Inventory> createMock();

    public Inventory getInventoryInfo(Long id);

}
