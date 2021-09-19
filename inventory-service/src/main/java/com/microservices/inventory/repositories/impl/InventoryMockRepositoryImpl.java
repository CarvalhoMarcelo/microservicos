package com.microservices.inventory.repositories.impl;

import com.microservices.inventory.models.Inventory;
import com.microservices.inventory.repositories.InventoryMockRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryMockRepositoryImpl implements InventoryMockRepository {

    @Override
    public List<Inventory> createMock() {

        List<Inventory> inventoryList = new ArrayList<Inventory>();

        inventoryList.add(new Inventory(301L, 101L, true));
        inventoryList.add(new Inventory(302L, 102L, false));
        inventoryList.add(new Inventory(303L, 103L, true));

        return inventoryList;

    }

    @Override
    public Inventory getInventoryInfo(Long id) {

        List<Inventory> inventoryList = createMock();

        for(Inventory inventory : inventoryList) {
            if(id.equals(inventory.getProductID()))
                return inventory;
        }

        return null;

    }
}
