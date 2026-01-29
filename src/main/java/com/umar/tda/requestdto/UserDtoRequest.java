/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.requestdto;

/**
 *
 * @author UMAR
 */
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDtoRequest {

    @NotBlank(message = "name cannot blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "email cannot blank")
    @Email(message = "Email should be valid")
    private String email;

    public void setName(String name) {
        this.name = name == null
                ? null
                : name.trim();

    }

    public void setEmail(String email) {
        this.email = email == null
                ? null
                : email.trim();
    }

}
