/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author UMAR
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ExceptionBadRequest.class})
    public ResponseEntity<Object> handleBadRequestException(ExceptionBadRequest e) {

        final HttpStatus BadRequest = HttpStatus.BAD_REQUEST;

        GlobalException apiException = new GlobalException(
                e.getMessage(),
                BadRequest,
                ZonedDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"))
        );

        return new ResponseEntity<>(apiException, BadRequest);

    }

    @ExceptionHandler(value = {ExceptionUserNotFound.class})
    public ResponseEntity<Object> handleUserNotFoundException(ExceptionUserNotFound e) {

        final HttpStatus UserNotFound = HttpStatus.NOT_FOUND;

        GlobalException apiException = new GlobalException(
                e.getMessage(),
                UserNotFound,
                ZonedDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"))
        );

        return new ResponseEntity<>(apiException, UserNotFound);

    }

    @ExceptionHandler(value = {ExceptionInvalidPassword.class})
    public ResponseEntity<Object> handleInvalidPasswordException(ExceptionInvalidPassword e) {

        final HttpStatus InvalidPass = HttpStatus.NOT_FOUND;

        GlobalException apiException = new GlobalException(
                e.getMessage(),
                InvalidPass,
                ZonedDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"))
        );

        return new ResponseEntity<>(apiException, InvalidPass);

    }

    @ExceptionHandler(ExceptionEmailFailToSend.class)
    public ResponseEntity<Object> handleEmailSendException(ExceptionEmailFailToSend e) {

        final HttpStatus failtosendemail = HttpStatus.INTERNAL_SERVER_ERROR;

        GlobalException apiException = new GlobalException(
                e.getMessage(),
                failtosendemail,
                ZonedDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"))
        );

        return new ResponseEntity<>(apiException, failtosendemail);
    }

}
