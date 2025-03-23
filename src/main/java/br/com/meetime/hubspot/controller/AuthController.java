package br.com.meetime.hubspot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meetime.hubspot.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/authorize")
    public ResponseEntity<String> getAuthorizationURL() {
        String url = authService.getAuthorizationURL();
        return ResponseEntity.ok(url);
    }
}