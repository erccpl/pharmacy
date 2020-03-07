package com.pharmacyclient.product;

import com.pharmacyclient.auth.JwtService;
import com.pharmacyclient.util.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//TODO: Uniform methods
@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    JwtService jwtService;


    public List<Product> findAll() {
        ResponseEntity<Product[]> response = restTemplate.exchange(EndPoints.BACKEND_ADRESS+EndPoints.PRODUCTS,
                HttpMethod.GET,
                jwtService.getHttpEntityWithJwtHeaders(),
                Product[].class);
        return Arrays.asList(response.getBody());
    }

    public Product findProduct(Long productId) {
        ResponseEntity<Product> product = restTemplate.exchange(EndPoints.BACKEND_ADRESS+EndPoints.PRODUCTS +"/"+ productId.toString(),
                HttpMethod.GET,
                jwtService.getHttpEntityWithJwtHeaders(),
                Product.class);
        return product.getBody();
    }

    public Product addProduct(Product product) {
        HttpEntity<Product> product_request = new HttpEntity<>(product, jwtService.getJwtHeaders());
        return restTemplate.postForObject (
                EndPoints.BACKEND_ADRESS + EndPoints.PRODUCTS,
                product_request,
                Product.class
        );
    }

    public Product updateProduct(Product product) {
        HttpEntity<Product> product_request = new HttpEntity<>(product, jwtService.getJwtHeaders());
        return restTemplate.exchange(
                EndPoints.BACKEND_ADRESS + EndPoints.PRODUCTS+"/"+product.getId(),
                HttpMethod.PUT,
                product_request,
                Product.class)
                .getBody();
    }

    //TODO: atrocious path
    public Product deleteProduct(Long productId) {
        HttpEntity<Long> product_delete_request = new HttpEntity<>(productId, jwtService.getJwtHeaders());
        return restTemplate.exchange(
                EndPoints.BACKEND_ADRESS+EndPoints.PRODUCTS+"/"+productId+"/delete",
                HttpMethod.DELETE,
                product_delete_request,
                Product.class)
                .getBody();
    }
}
