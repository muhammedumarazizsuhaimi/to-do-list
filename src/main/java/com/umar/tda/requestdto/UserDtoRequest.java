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

@Getter
@Setter
@NoArgsConstructor
public class UserDtoRequest {

    
    @NotBlank(message = "name cannot blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    
    @NotBlank(message = "email cannot blank")
    @Email(message = "Email should be valid")
    private String email;

    
    @NotBlank(message = "password cannot blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).*$",
        message = "Password must include uppercase, lowercase, number, and special character"
    )
    private String password;

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
