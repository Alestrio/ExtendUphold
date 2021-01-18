package com.alestrio.extenduphold;

public class NoLoggedUserException extends Exception{

    public NoLoggedUserException() {
    }

    public NoLoggedUserException(String message) {
        super(message);
    }
}
