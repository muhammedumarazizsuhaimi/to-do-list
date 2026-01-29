/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umar.tda.service;

import com.umar.tda.entity.User;
import com.umar.tda.requestdto.UserDtoRequest;
import com.umar.tda.responsedto.UserDtoResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author UMAR
 */
@Service
public interface UserService {

   

//    UserDtoResponse GetMyProfile(Long id);
    User getUserById(Long id);

    UserDtoResponse UpdateProfile(Long id, UserDtoRequest userdtorequest);

    void deleteAccount(Long id);

    

}
