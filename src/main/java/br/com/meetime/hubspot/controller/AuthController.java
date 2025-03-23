package br.com.meetime.hubspot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/authorize")
    public ResponseEntity<String> getAuthorizationURL() {
        //Chamar service
        return ResponseEntity.ok("Provisorio");
    }
}