/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umar.tda.repository;

import com.umar.tda.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author UMAR
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

   Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    
    @Query("SELECT u FROM user WHERE u.verification_code = ?1 ")
    User findByVerificationCode(String code);
    }
