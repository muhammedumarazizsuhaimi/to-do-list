/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.responsedto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author UMAR
 */
@Data
@Builder
public class UserDtoResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final boolean verified;

}
