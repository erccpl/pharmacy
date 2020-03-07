package com.pharmacyclient.inventory;

import com.pharmacyclient.auth.JwtService;
import com.pharmacyclient.util.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Endpoint;
import java.util.Arrays;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    JwtService jwtService;

    public List<InventoryItem> findAll(Long productId) {
        ResponseEntity<InventoryItem[]> response = restTemplate.exchange(
                EndPoints.BACKEND_ADRESS+EndPoints.PRODUCTS+"/"+productId.toString()+EndPoints.INVENTORY,
                HttpMethod.GET,
                jwtService.getHttpEntityWithJwtHeaders(),
                InventoryItem[].class);
        return Arrays.asList(response.getBody());
    }
}
