package com.sancom.careerday.Exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
