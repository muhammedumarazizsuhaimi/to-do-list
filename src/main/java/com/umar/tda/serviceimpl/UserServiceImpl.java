/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.serviceimpl;

import com.umar.tda.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.transaction.Transactional;
import net.bytebuddy.utility.RandomString;

import com.umar.tda.exception.ExceptionUserNotFound;
import com.umar.tda.entity.User;
import com.umar.tda.exception.ExceptionBadRequest;
import com.umar.tda.repository.UserRepo;
import com.umar.tda.requestdto.UserDtoRequest;
import com.umar.tda.responsedto.UserDtoResponse;
import com.umar.tda.service.NotificationService;

/**
 *
 * @author UMAR
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepository;
    private final NotificationService notificationService;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepo userRepository, NotificationService notificationService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    // register user for first timer, check email & password
    @Override
    public UserDtoResponse register(UserDtoRequest request, String frontURL) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ExceptionBadRequest("Email already registered : " + request.getEmail());
        }
        if (request.getPassword().isBlank() || request.getPassword().length() < 8) {
            throw new ExceptionBadRequest("Password must be at least 8 characters long");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setVerificationCode(RandomString.make(64));
        user.setVerified(false);

        userRepository.save(user);

        notificationService.VerificationNotification(user, frontURL);

        return UserDtoResponse
                .builder()
                .id(user.getUserid())
                .name(user.getName())
                .email(user.getEmail())
                .verified(user.isVerified())
                .build();

    }

    @Override
    public boolean verify(String verificationCode) {

        User user = userRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isVerified()) {

            return false;

        } else {

            user.setVerificationCode(null);
            user.setVerified(true);

            userRepository.save(user);

            return true;
        }
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
        if (request.getEmail() != null && !request.getName().isBlank() && !user.getEmail().equals(request.getEmail())) {
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new ExceptionBadRequest("Email already been used");
            }
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
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
