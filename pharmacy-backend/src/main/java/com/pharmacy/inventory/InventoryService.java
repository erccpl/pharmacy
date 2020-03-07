package com.pharmacy.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryService {
    @Autowired
    InventoryItemRepository inventoryItemRepository;

    public List<InventoryItem> getInventoryItemsForProduct(Long productId) {
        return inventoryItemRepository.findAllByProductId(productId);
    }

    public void addInventoryItem(InventoryItem item) {
        inventoryItemRepository.save(item);
    }

    public void deleteInventoryItem(InventoryItem item) {
        inventoryItemRepository.delete(item);
    }
}
