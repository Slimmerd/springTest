package ru.test.springTest.exceptions;

public class UserDontExistException extends Exception{
    public UserDontExistException(String message) {
        super(message);
    }
}
