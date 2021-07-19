package fr.sg.kata;

import fr.sg.kata.exception.InvalidCustomDelimiterException;
import fr.sg.kata.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String BASIC_DELIMITER = ",|\n";
    public static final String BASIC_INPUT_PATTERN = "^(-?\\d)+((?:\\,(-?\\d)+)/*|(?:\\\n(-?\\d)+)*)*";
    public static final String CUSTOM_DELIMITER_START_LINE = "//";


    /**
     * This method aims to parse the String given by the user
     * and return an Array of numbers in order to calculate the sum
     *
     * @param input String
     * @return String[]
     */
    public static String[] parse(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_START_LINE)) {
            return parseWithCustomDelimiter(input);
        } else {
            return parseInputWithBasicDelimiter(input);
        }

    }

    /**
     * This method aims to parse an input with the basic delimiter
     *
     * @param input String
     * @return String[]
     */
    private static String[] parseInputWithBasicDelimiter(String input) {
        Pattern pattern = Pattern.compile(BASIC_INPUT_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidInputException();
        }
        return input.split(BASIC_DELIMITER);
    }

    /**
     * This method aims to parse an input with a custom delimiter
     *
     * @param input String
     * @return String[]
     */
    private static String[] parseWithCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new InvalidCustomDelimiterException();
        }
        String delimiter = matcher.group(1);
        String numbers = matcher.group(2);
        return numbers.split(delimiter);
    }
}
