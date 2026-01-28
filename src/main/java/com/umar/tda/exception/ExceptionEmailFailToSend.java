/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.exception;

/**
 *
 * @author UMAR
 */
public class ExceptionEmailFailToSend extends RuntimeException {

    public ExceptionEmailFailToSend(String message) {
        super(message);
    }

    public ExceptionEmailFailToSend(String message, Throwable cause) {
        super(message, cause);
    }
    

}
