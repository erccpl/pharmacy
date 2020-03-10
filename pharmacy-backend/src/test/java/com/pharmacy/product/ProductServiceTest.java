package com.pharmacy.product;

import com.pharmacy.TestObjectFactory;
import com.pharmacy.category.Category;
import com.pharmacy.category.CategoryName;
import com.pharmacy.category.CategoryRepository;
import com.pharmacy.inventory.InventoryItem;
import com.pharmacy.supplier.Supplier;
import org.assertj.core.internal.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private static List<Product> products;

    @BeforeEach
    public void init() {
        products = new ArrayList<>();
        Product p1 = TestObjectFactory.newProduct(1L, "test1", CategoryName.INTRAVENOUS);
        Product p2 = TestObjectFactory.newProduct(2L, "test2", CategoryName.AEROSOL);
        Product p3 = TestObjectFactory.newProduct(3L, "test3", CategoryName.ORAL);
        products = Stream.of(p1, p2, p3).collect(Collectors.toList());
    }

    @Mock
    private ProductRepository productRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    public void findAllProductsTest() throws Exception {
        given(productRepository.findAll()).willReturn(Collections.emptyList());
        List<Product> products = productService.findAllProducts();
        assertTrue(products.isEmpty());
        verify(productRepository).findAll();
    }

    @Test
    public void addProductTest() throws Exception {
        Product product = TestObjectFactory.newProduct(4L, "testproduct", CategoryName.EYEDROPS);
        given(categoryRepository.findByName(product.getCategory().getName())).willReturn(product.getCategory());
        given(productRepository.save(product)).willReturn(product);

        productService.addProduct(product);
        verify(productRepository).save(product);
    }

    @Test
    public void findProduct_productFoundTest() throws Exception {
        Product product = products.get(1);
        Long id = product.getId();
        given(productRepository.findById(id)).willReturn(Optional.of(product));

        productService.findProduct(id);
        verify(productRepository).findById(id);
    }

    @Test
    public void findProduct_productNotFoundTest() throws Exception {
        Long id = 4L;
        given(productRepository.findById(id)).willReturn(Optional.empty());

        productService.findProduct(id);
        verify(productRepository).findById(id);
    }

   @Test
   public void updateProductTest() throws Exception {
       Product product = TestObjectFactory.newProduct(4L, "testproduct", CategoryName.EYEDROPS);
       given(categoryRepository.findByName(product.getCategory().getName())).willReturn(product.getCategory());
       given(productRepository.save(product)).willReturn(product);

       productService.updateProduct(product);
       verify(productRepository).save(product);

   }

   @Test
   public void deleteProductTest() throws Exception {
       Long id = 3L;
       productService.deleteProduct(id);
       verify(productRepository).deleteById(id);
    }

}
