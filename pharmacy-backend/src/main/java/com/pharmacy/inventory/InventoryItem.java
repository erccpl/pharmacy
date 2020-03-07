package com.pharmacy.inventory;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmacy.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;



@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="inventory")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Product product;
    @PositiveOrZero
    private Integer stock;
    @Column(columnDefinition="Decimal(10,2)")
    private float salePrice;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;


}
