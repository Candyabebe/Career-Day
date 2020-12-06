package com.sancom.careerday.Exceptions;

public class OldPasswordWrongException extends RuntimeException {
    private static final long serialVersionUID = -5483903431877106547L;
    public OldPasswordWrongException(String message){super(message);}
}
