package com.pharmacyclient.product;

import com.pharmacyclient.category.Category;
import com.pharmacyclient.supplier.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Category category;
    private ProductUnit unit;
    private Integer quantity;
    private float retailPrice;
    private String description;
    private Set<Supplier> suppliers = new HashSet<>();

}
