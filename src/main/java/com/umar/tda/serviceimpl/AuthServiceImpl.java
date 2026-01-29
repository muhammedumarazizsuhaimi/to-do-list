/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.serviceimpl;

import com.umar.tda.entity.User;
import com.umar.tda.exception.ExceptionBadRequest;
import com.umar.tda.repository.UserRepo;
import com.umar.tda.requestdto.UserDtoRequest;
import com.umar.tda.responsedto.UserDtoResponse;
import com.umar.tda.service.AuthService;
import com.umar.tda.service.NotificationService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author UMAR
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepository;
    private final NotificationService notificationService;

    @Autowired
    public AuthServiceImpl(UserRepo userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    @Override
    public UserDtoResponse register(UserDtoRequest request, String frontURL) {

        String normalizedEmail = request.getEmail().toLowerCase();

        if (userRepository.existsByEmail(normalizedEmail)) {
            throw new ExceptionBadRequest("Email already registered : " + request.getEmail());
        }

//        User user = User
//                .builder()
//                .name(request.getName())
//                .email(normalizedEmail)
//                .verified(false)
//                .enabled(false)
//                .verificationCode(RandomString.make(64))
//                .verificationExpiry(LocalDateTime.now().plusHours(24))
//                .build();
        User user = new User(
                request.getName(),
                normalizedEmail,
                RandomString.make(64),
                false,
                LocalDateTime.now().plusHours(24),
                false
        );

        userRepository.save(user);

        notificationService.sendVerificationEmail(user, frontURL);

        return UserDtoResponse.builder()
                .id(user.getUserid())
                .name(user.getName())
                .email(user.getEmail())
                .verified(user.isVerified())
                .build();

    }

    @Override
    public boolean verifyUser(String verificationCode) {

        if (verificationCode == null || verificationCode.isBlank()) {
            return false;
        }
        User user = userRepository.findByVerificationCode(verificationCode);
        if (user == null || user.isVerified()) {
            return false;
        }
        // Optional: check expiry
        if (user.getVerificationExpiry() != null && user.getVerificationExpiry().isBefore(LocalDateTime.now())) {
            return false; // expired
        }

        user.setVerified(true);
        user.setEnabled(true);
        user.setVerificationCode(null);
        user.setVerificationExpiry(null);

        userRepository.save(user);

        return true;
    }

}
