/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.controller;

import com.umar.tda.requestdto.UserDtoRequest;
import com.umar.tda.responsedto.UserDtoResponse;
import com.umar.tda.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author UMAR
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDtoResponse> register(@Valid @RequestBody UserDtoRequest request, @RequestHeader String frontURL) {

        UserDtoResponse response = authService.register(request, frontURL);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam String verificationCode) {

        boolean success = authService.verifyUser(verificationCode);

        if (success) {
            return ResponseEntity.ok("Account verified successfully. You can now log in.");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired verification code.");
        }
    }

    // login user
    @PostMapping("/login")
    public ResponseEntity<String> signin() {

        return ResponseEntity.ok("Login successful");
    }
}
