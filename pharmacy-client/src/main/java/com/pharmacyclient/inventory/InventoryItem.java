package com.pharmacyclient.inventory;

import com.pharmacyclient.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class InventoryItem {
    private Long id;
    private Product product;
    private Integer stock;
    private float salePrice;
    private Date expirationDate;
}