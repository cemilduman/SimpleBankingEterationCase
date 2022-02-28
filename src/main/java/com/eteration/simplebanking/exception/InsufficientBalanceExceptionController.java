package com.eteration.simplebanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InsufficientBalanceExceptionController {

    @ExceptionHandler(value = InsufficientBalanceException.class)
    public ResponseEntity<Object> exception(InsufficientBalanceException exception){
        return new ResponseEntity<Object>("Balance of the account is insufficient. To try again, " +
                "please be sure you deposited enough money before transaction", HttpStatus.NOT_FOUND);
    }
}
