/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umar.tda.service;

import com.umar.tda.requestdto.UserDtoRequest;
import com.umar.tda.responsedto.UserDtoResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author UMAR
 */
@Service
public interface AuthService {
    
    /**
     * Register a new user and send verification email.
     *
     * @param  request  User registration data
     * @param frontURL Base URL for email verification link
     * @return User DTO with created user info
     */
     UserDtoResponse register(UserDtoRequest request , String frontURL);

     /**
     * verify user by their verification code
     * @param  verificationCode  User registration data
     * @return return true if verification succeed, else false
     */
    boolean verifyUser(String verificationCode);
    
}
