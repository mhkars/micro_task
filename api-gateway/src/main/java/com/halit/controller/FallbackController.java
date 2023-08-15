package com.halit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fallback")
@RestController
public class FallbackController {


    @GetMapping("/authservice")
    public ResponseEntity<String> authServiceFallback() {


        return ResponseEntity.ok("Auth service Suanda hizmet vermiyor");
    }


    @GetMapping("/userservice")
    public ResponseEntity<String> userServiceFallback() {


        return ResponseEntity.ok("User service Suanda hizmet vermiyor");
    }




}