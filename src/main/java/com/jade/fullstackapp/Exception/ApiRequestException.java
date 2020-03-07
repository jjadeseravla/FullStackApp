package com.jade.fullstackapp.Exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }

    //public ApiRequestException(Throwable cause) {
//        super(cause);
//    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }


}
