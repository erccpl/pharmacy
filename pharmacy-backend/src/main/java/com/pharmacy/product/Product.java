package com.pharmacy.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmacy.category.Category;
import com.pharmacy.inventory.InventoryItem;
import com.pharmacy.supplier.Supplier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private ProductUnit unit;
    @PositiveOrZero
    private Integer quantity;
    @Column(columnDefinition="Decimal(10,2)")
    private float retailPrice;
    private String description;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "product_supplier",
            joinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "supplier_id", referencedColumnName = "id") }
    )
    private Set<Supplier> suppliers = new HashSet<>();

    public void setSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
    }

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "product")
    @JsonIgnore
    private Set<InventoryItem> inventoryItems;

    public Product (Long id) {
        this.id = id;
    }

}
