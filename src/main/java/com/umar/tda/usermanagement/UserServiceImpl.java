/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.usermanagement;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.umar.tda.exception.ExceptionUserNotFound;
import com.umar.tda.exception.ExceptionBadRequest;

/**
 *
 * @author UMAR
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    // Get User By ID (centralized method)
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()
                        -> new ExceptionUserNotFound("User not found with id: " + id));
    }

    @Override
    public UserDtoResponse UpdateProfile(Long id, UserDtoRequest request) {

        User user = getUserById(id);

        if (request.getName() != null && !request.getName().isBlank()) {
            user.setName(request.getName());
        }
        if (request.getEmail() != null && !request.getEmail().isBlank() && !user.getEmail().equals(request.getEmail())) {

            String normalizedEmail = request.getEmail().toLowerCase();

            if (userRepository.existsByEmail(normalizedEmail)) {
                throw new ExceptionBadRequest("Email already been used");
            }
            user.setEmail(normalizedEmail);
        }

        User savedupdate = userRepository.save(user);

        return UserDtoResponse
                .builder()
                .id(savedupdate.getUserid())
                .name(savedupdate.getName())
                .email(savedupdate.getEmail())
                .build();
    }

    // Delete Account
    @Override
    public void deleteAccount(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

}
