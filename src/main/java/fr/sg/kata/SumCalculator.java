package fr.sg.kata;

import fr.sg.kata.exception.NegativeInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumCalculator {

    /**
     * This method is the main method which aims to parse the input string, then calculate the sum
     * @param numbers String
     * @return int
     */
    public static int add(String numbers) {
        if (!numbers.isEmpty()) {
            String[] stringList = StringParser.parse(numbers);
            List<Integer> numericList = convertStringListToIntList(stringList);
            checkNegativeInput(numericList);
            return numericList.stream().reduce(0, Integer::sum);
        }
        return 0;
    }

    /**
     * This method aims to convert an Array of String to a List of Integer
     * @param numbers String[]
     * @return List<Integer>
     */
    private static List<Integer> convertStringListToIntList(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * This method aims to check if the given numbers contain negative numbers then throw an Exception
     * @param numericList List<Integer>
     */
    private static void checkNegativeInput(List<Integer> numericList) {
        StringBuilder stringBuilder = new StringBuilder();
        numericList.stream()
                .filter(number -> number < 0)
                .forEach(number -> stringBuilder.append(number).append(" "));
        String negativeNumbers = stringBuilder.toString();
        if (!negativeNumbers.isEmpty()) {
            throw new NegativeInputException(negativeNumbers);
        }
    }
}
