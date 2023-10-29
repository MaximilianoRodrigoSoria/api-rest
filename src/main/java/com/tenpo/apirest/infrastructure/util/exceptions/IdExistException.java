package com.tenpo.apirest.infrastructure.util.exceptions;

public class IdExistException extends RuntimeException{
    private final static String ERROR_MESSAGE = "This user exist";
    public IdExistException(String tableName){
        super(String.format(ERROR_MESSAGE,tableName));
    }
}