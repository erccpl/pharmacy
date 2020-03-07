package com.pharmacyclient.category;

import com.pharmacyclient.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class Category {
    private Long id;
    private CategoryName name;
    private Set<Product> products;

}
