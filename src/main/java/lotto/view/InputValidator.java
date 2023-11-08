package lotto.view;

import static lotto.constants.ErrorMessage.IS_NOT_NUMERIC_ERROR_MESSAGE;

import java.util.ArrayList;

public class InputValidator {
    public static ArrayList<Integer> validateAndParseNumbersInput(String input) {
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        String[] winningNumbers = input.split(",");

        for (String winningNumber : winningNumbers) {
            inputNumbers.add(validateAndParseInput(winningNumber));
        }
        return inputNumbers;
    }

    public static int validateAndParseInput(String input) {
        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC_ERROR_MESSAGE);
        }
    }
}