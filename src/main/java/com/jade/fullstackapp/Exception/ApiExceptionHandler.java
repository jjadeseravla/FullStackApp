package com.jade.fullstackapp.Exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//
////this class handles multiple exception handlers by @ControllerAdvice
//@ControllerAdvice
//public class ApiExceptionHandler {
//
////tell spring that this method is responsible for handling this exception by adding @ExceptionHandler
////this class will be fed into the ApiException e parameter in the method below
////this handles custom or existing exceptions that can be customised when throwing the error to the client
//@ExceptionHandler(value = {ApiRequestException.class})
//    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
//        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
//        //need to create a payload containing exception details
//        ApiException apiException = new ApiException(
//            e.getMessage(),
//            e, //pass the throwable (eg here its e)
//            //shift control and space to to choose Http status
//            badRequest,
//            ZonedDateTime.now(ZoneId.of("Z"))
//        );
//        // that we will send to the response entity
//        return new ResponseEntity<>(apiException, badRequest);
//    }
//}
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e, WebRequest webRequest) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}