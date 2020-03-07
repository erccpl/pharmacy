package com.pharmacyclient.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@Service
public class JwtService {
    private String jwt;
    private HttpHeaders jwtHeaders;
    private HttpEntity<String> httpEntityWithJwtHeaders;

    public HttpEntity<String> createEntityWithJwtHeaders(String jwt){
        this.jwt = jwt;
        jwtHeaders  = new HttpHeaders();
        jwtHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        jwtHeaders.setContentType(MediaType.APPLICATION_JSON);
        jwtHeaders.set("Authorization", "Bearer " + this.jwt);

        this.httpEntityWithJwtHeaders= new HttpEntity<>(jwtHeaders);
        return this.httpEntityWithJwtHeaders;
    }

    public void invalidateJwt() {
        this.jwt = "";
        this.jwtHeaders.set("Authorization", this.jwt);
        this.httpEntityWithJwtHeaders = new HttpEntity<>(jwtHeaders);
    }
}
