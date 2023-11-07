package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InvalidCommaMissingException;
import lotto.exception.InvalidNonNumericInputException;

public class InputParser {
    private static final String DELIMITER = ",";

    public static int parseStringToInteger(String inputNumber) {
        return convertToInteger(inputNumber);
    }

    public static List<Integer> parseStringToIntegerList(String inputNumbers) {
        if (containComma(inputNumbers)) {
            return splitAndConvertToInteger(inputNumbers);
        }
        throw new InvalidCommaMissingException();
    }

    private static int convertToInteger(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new InvalidNonNumericInputException();
        }
    }

    private static boolean containComma(String inputNumbers) {
        return inputNumbers.contains(DELIMITER);
    }

    private static List<Integer> splitAndConvertToInteger(String inputNumbers) {
        try {
            return Arrays.stream(inputNumbers.split(DELIMITER)).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidNonNumericInputException();
        }
    }
}
