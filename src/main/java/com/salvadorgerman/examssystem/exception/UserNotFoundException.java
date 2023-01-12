package com.salvadorgerman.examssystem.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("User doesn't exist");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
