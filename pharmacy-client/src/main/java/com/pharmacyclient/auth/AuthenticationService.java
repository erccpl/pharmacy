package com.pharmacyclient.auth;


import com.pharmacyclient.product.Product;
import com.pharmacyclient.util.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtService jwtService;


    public Optional<String> getJwt(AuthenticationRequest request) throws HttpClientErrorException {
        AuthenticationResponse response;
        try {
            response = restTemplate.postForObject(EndPoints.BACKEND_ADRESS + EndPoints.AUTHENTICATE, request, AuthenticationResponse.class);
        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }

        jwtService.createEntityWithJwtHeaders(response.getJwt());
        return Optional.of(response.getJwt());
    }
}
