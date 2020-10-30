package com.cap.apps.customerbootjparest.exceptions;

public class CustomerNotExistException extends RuntimeException{

    public CustomerNotExistException(String message) {
        super(message);
    }
}
