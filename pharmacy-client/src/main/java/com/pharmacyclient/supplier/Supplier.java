package com.pharmacyclient.supplier;


import com.pharmacyclient.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class Supplier {
    private Long id;
    private String name;
    private Set<Product> products;
    private String description;
}
