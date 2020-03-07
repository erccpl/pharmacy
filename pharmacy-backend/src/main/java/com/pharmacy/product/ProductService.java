package com.pharmacy.product;

import com.pharmacy.category.Category;
import com.pharmacy.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//TODO: make Hibernate automatically check Category by name
//TODO: error handling
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
       Category category = categoryRepository.findByName(product.getCategory().getName());
       product.setCategory(category);
       productRepository.save(product);
    }

    public Product findProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product) {
        Category category = categoryRepository.findByName(product.getCategory().getName());
        product.setCategory(category);
        productRepository.save(product);

    }
}
