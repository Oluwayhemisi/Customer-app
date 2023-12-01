package com.example.mycustomerapp.exception;

public class CustomerException extends Exception {
    private int statusCode;
    public CustomerException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }


}