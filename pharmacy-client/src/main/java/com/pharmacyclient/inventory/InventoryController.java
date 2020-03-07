package com.pharmacyclient.inventory;

import com.pharmacyclient.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @Autowired
    ProductService productService;


    //TODO: this is a really redundant call to the database for the name of the product
    @RequestMapping(path = "/products/{productId}/inventory", method = RequestMethod.GET)
    public String getAllProductInventoryItems(Model model, @PathVariable Long productId) {
        model.addAttribute("product_name", productService.findProduct(productId).getName());
        model.addAttribute("inventory", inventoryService.findAll(productId));
        return "product_inventory";
    }

}
