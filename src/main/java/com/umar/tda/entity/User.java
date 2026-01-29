/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;

/**
 *
 * @author UMAR
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED) // required by JPA only
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 64)
    private String verificationCode;

    @Column(nullable = false)
    private boolean verified;

    private LocalDateTime verificationExpiry;

    @Column(nullable = false)
    private boolean enabled;

    @Builder
    public User(String name, String email, String verificationCode, boolean verified, LocalDateTime verificationExpiry, boolean enabled) {
        this.name = name;
        this.email = email;
        this.verificationCode = verificationCode;
        this.verified = verified;
        this.verificationExpiry = verificationExpiry;
        this.enabled = enabled;
    }

}
