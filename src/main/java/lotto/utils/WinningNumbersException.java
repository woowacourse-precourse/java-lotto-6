package lotto.utils;

import java.util.*;

import static lotto.utils.ExceptionMessage.*;

public class WinningNumbersException {
    public void underLength(String input) {
        String[] inputData = input.split(",");
        if (inputData.length < 6) {
            throw new IllegalArgumentException(UNDER_LENGTH.getMessage());
        }
    }

    public void exceedsLength(String input) {
        String[] inputData = input.split(",");
        if (inputData.length > 6) {
            throw new IllegalArgumentException(EXCEEDS_LENGTH.getMessage());
        }
    }
    public void notNumeric(String input) {
        String nonCommaInput = input.replace(",","");

        try {
            Integer.parseInt(nonCommaInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
    public void outsideRange(String input) {
        String[] inputData = input.split(",");
        int numberValue;

        for(String value : inputData) {
            numberValue = Integer.parseInt(value);
            if (numberValue > 45 || numberValue < 0) {
                throw new IllegalArgumentException(OUTSIDE_RANGE.getMessage());
            }
        }
    }
    public void duplicateNumber(String input) {
        Set<String> inputData = new HashSet<>(Arrays.asList(input.split(",")));

        if (inputData.size() < 6) {
            throw new IllegalArgumentException(DUPLICATE_INPUT.getMessage());
        }
    }

    public void nonComma(String input) {
        String[] inputData = input.split("");
        List<String> test = new ArrayList<>(Arrays.asList(inputData));

        if (!test.contains(",") && test.size() > 1) {
            throw new IllegalArgumentException(NON_COMMA.getMessage());
        }
    }

    public void lastComma(String input) {
        String[] inputData = input.split("");
        List<String> test = new ArrayList<>(Arrays.asList(inputData));

        if (test.get(test.size()-1).equals(",")) {
            throw new IllegalArgumentException(DELETE_COMMA.getMessage());
        }
    }
}
