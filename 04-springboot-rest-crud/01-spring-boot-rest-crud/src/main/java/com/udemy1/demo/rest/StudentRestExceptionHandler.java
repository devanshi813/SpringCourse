package com.udemy1.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentRestExceptionHandler {

    @ControllerAdvice
    public class StudentRestExceptionalHandler {

        // Add an exception handler using @exceptionHandler
        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
            // create s StudentErrorResponse

            StudentErrorResponse error = new StudentErrorResponse();

            error.setStatus(HttpStatus.NOT_EXTENDED.value());
            error.setMessage(exc.getMessage());
            error.setTimestamp(System.currentTimeMillis());

            // return ResponseEntity

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        // add exception to catch all types of exceptions
        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
            // create s StudentErrorResponse

            StudentErrorResponse error = new StudentErrorResponse();

            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setMessage(exc.getMessage());
            error.setTimestamp(System.currentTimeMillis());

            // return ResponseEntity

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

}