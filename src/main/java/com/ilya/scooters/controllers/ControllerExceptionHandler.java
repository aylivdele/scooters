package com.ilya.scooters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleSQLException(SQLException exception){
        return new ResponseEntity<>("Database error:" + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception){
        return new ResponseEntity<>("Unknown error:" + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
