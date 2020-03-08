package com.pharmacy.inventory;


import com.pharmacy.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/products/{productId}/inventory")
    private ResponseEntity<List<InventoryItem>> getProductInventory(@PathVariable Long productId) {
        List<InventoryItem> inventory = inventoryService.getInventoryItemsForProduct(productId);
        if (!inventory.isEmpty()) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products/{productId}/inventory")
    private ResponseEntity<String> addProductInventoryItem (@RequestBody InventoryItem inventoryItem, @PathVariable Long productId) {
        inventoryItem.setProduct(new Product(productId));
        inventoryService.addInventoryItem(inventoryItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/products/{productId}/inventory/{itemId}")
    private ResponseEntity<String> updateProductInventoryItem (@RequestBody InventoryItem inventoryItem, @PathVariable Long productId, @PathVariable Long itemId) {
        inventoryItem.setProduct(new Product(productId));
        inventoryItem.setId(itemId);
        inventoryService.addInventoryItem(inventoryItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}/inventory/{itemId}")
    private ResponseEntity<String> deleteProductInventoryItem (@RequestBody InventoryItem item, @PathVariable Long productId, @PathVariable Long itemId) {
        item.setId(itemId);
        inventoryService.deleteInventoryItem(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
