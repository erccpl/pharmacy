package com.pharmacy.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;




//This is a UNIT TEST: no calls to the database, no calls to the endpoints
// should take milliseconds and should not start the Spring Boot app
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    public void findAllProductsTest() throws Exception {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<Product> products = productService.findAllProducts();
        assertTrue(products.isEmpty());
        verify(productRepository).findAll();
    }


    //addProductTest

    //findProductTest

    //updateProductTest

    //deleteProductTest
}
