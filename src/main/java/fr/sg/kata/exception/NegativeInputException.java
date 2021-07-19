package fr.sg.kata.exception;

public class NegativeInputException extends RuntimeException{
    public NegativeInputException(String s) {
        super(String.format("Negatives not allowed :: %s", s));
    }
}
