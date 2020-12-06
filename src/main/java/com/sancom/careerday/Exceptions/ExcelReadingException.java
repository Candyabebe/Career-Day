package com.sancom.careerday.Exceptions;

public class ExcelReadingException extends RuntimeException {
    public static final long serialVersionUID = 7308106901982961836L;
    public ExcelReadingException (String message){super(message);}
    public  ExcelReadingException(String message,Throwable cause){
        super(message, cause);
    }

}
