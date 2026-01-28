/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.exception;

/**
 *
 * @author UMAR
 */
public class ExceptionBadRequest extends RuntimeException {

    public ExceptionBadRequest(String message) {
        super(message);

    }

    public ExceptionBadRequest(String message, Throwable cause) {
        super(message, cause);
    }

}
