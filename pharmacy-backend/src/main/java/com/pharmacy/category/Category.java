package com.pharmacy.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmacy.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @OneToMany(mappedBy="category")
    @JsonIgnore
    private Set<Product> products;

}
