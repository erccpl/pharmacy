package com.pharmacyclient.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/login")
    private String getLoginForm(Model model) {
        AuthenticationRequest request = new AuthenticationRequest();
        model.addAttribute("authrequest", request);
        return "login";
    }

    @GetMapping("/logout")
    private String getLogoutPage() {
        jwtService.invalidateJwt();
        return "logout";
    }

    @PostMapping("/authenticate")
    private String getAuthentication(AuthenticationRequest request) {
        Optional<String> jwt = authenticationService.getJwt(request);
        if ( !jwt.isPresent() ) {
            return "login_error";
        }
        jwtService.setJwt(jwt.get());
        return "main_panel";
    }


}
