package com.cap.apps.customerbootdatajparest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionalHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerIdException.class)
    public String handleCustomerIdException(CustomerIdException e){
        return e.getMessage();

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerNameException.class)
    public String handleCustomerNameException(CustomerNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotExistException.class)
    public String handleCustomerNotExistException(CustomerNotExistException e){
        return e.getMessage();
    }
}
