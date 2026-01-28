/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.exception;

/**
 *
 * @author UMAR
 */
public class ExceptionUserNotFound extends IllegalArgumentException {

    public ExceptionUserNotFound(String message) {
        super(message);
    }

    public ExceptionUserNotFound(String message, Throwable cause) {
        super(message, cause);
    }

}
