package com.salvadorgerman.examssystem.exception;

public class UserFoundException extends Exception{

    public UserFoundException() {
        super("The user already exists in the database");
    }

    public UserFoundException(String message) {
        super(message);
    }
}
