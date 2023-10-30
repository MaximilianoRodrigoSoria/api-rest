package com.tenpo.apirest.infrastructure.util.exceptions;

public class CannotParseObjectException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Not parse Object Exception";
    public CannotParseObjectException(String tableName){
        super(ERROR_MESSAGE);
    }
}
