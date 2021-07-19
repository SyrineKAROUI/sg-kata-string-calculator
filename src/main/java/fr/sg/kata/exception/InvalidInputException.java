package fr.sg.kata.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super("Invalid Input!");
    }
}
