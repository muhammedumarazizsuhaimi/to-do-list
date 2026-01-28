/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.responsedto;

import lombok.Builder;

/**
 *
 * @author UMAR
 */
@Builder
public class UserDtoResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final boolean verified;

    public UserDtoResponse(Long id, String name, String email, boolean verified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.verified = verified;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerified() {
        return verified;
    }

    

    
    
    
    

}
