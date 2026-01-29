/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umar.tda.service;

import com.umar.tda.entity.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author UMAR
 */
@Service
public interface NotificationService {
    
    /**
     * Send verification email to a newly registered user.
     *
     * @param user     The user to send email to
     * @param frontURL Base URL for constructing verification link
     */
    void sendVerificationEmail(User user, String frontURL);
    
}
