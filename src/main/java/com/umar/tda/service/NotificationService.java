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
    
    void VerificationNotification(User user, String frontURL);
    
}
