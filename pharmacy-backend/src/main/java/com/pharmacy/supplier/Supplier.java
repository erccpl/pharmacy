package com.pharmacy.supplier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmacy.company.Company;
import com.pharmacy.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@DiscriminatorValue(value = "S")
@Table(name="suppliers")
@NoArgsConstructor
@Getter
@Setter
public class Supplier extends Company {

    @ManyToMany(mappedBy = "suppliers")
    @JsonIgnore
    private Set<Product> products;

    public void addToSuppliedProducts(Product product) {
        this.products.add(product);
        product.setSupplier(this);
    }


}
