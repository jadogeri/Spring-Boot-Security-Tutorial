package com.josephadogeridev.spring.security_6.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @GetMapping("")
    public String welcomeMessage() {
        return "Welcome to Spring Security 6";
    }

    @PostMapping("/")
    public String postMessage() {
        return "Welcome to post messate Spring Security 6";
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");

    }
}
