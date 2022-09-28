package ru.test.springTest.exceptions;

public class TodoDontExistException extends Exception{
    public TodoDontExistException(String message) {
        super(message);
    }
}
