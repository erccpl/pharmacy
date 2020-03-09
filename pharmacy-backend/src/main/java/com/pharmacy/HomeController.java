package com.pharmacy;

import com.pharmacy.auth.AuthenticationRequest;
import com.pharmacy.auth.AuthenticationResponse;
import com.pharmacy.user.PharmacyUserDetailsService;
import com.pharmacy.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


// Kudos to Koushik from JavaBrains
// Source: https://github.com/koushikkothagal/spring-security-jwt
@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PharmacyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;


    @GetMapping("/")
    public ResponseEntity<String> dummyEntryPoint() {
        return ResponseEntity.ok(new String("For test purposes"));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
