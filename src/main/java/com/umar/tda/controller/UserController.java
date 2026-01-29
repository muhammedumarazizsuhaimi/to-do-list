/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.controller;

import com.umar.tda.requestdto.UserDtoRequest;
import com.umar.tda.responsedto.UserDtoResponse;
import com.umar.tda.service.UserService;

import java.nio.file.attribute.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author UMAR
 */
@RestController
@RequestMapping("/api/Guest")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    // login user
    @PostMapping("/login")
    public ResponseEntity<String> signin() {

        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDtoResponse> getProfile(@AuthenticationPrincipal UserPrincipal principal) {
        // principal contains userId from JWT/session
        UserDtoResponse profile = userService.getProfileById(principal.getId());
        return ResponseEntity.ok(profile);
    }

    // update profile user
    @PostMapping("/profile/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDtoRequest userdtorequest) {

        UserDtoResponse response = userService.UpdateProfile(id, userdtorequest);

        return ResponseEntity.ok(response);

    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        userService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
