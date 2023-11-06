package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static lotto.utils.ExceptionMessage.*;

public class WinningNumbersException {
    public void exceedsLength(String input) {
        String[] inputData = input.split(",");
        if (inputData.length > 6) {
            throw new IllegalArgumentException(EXCEEDS_LENGTH.getMessage());
        }
    }
    public void notNumeric(String input) {
        try {
            Integer.parseInt(input);
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

        if (inputData.size() <= 6) {
            throw new IllegalArgumentException(String.valueOf(DUPLICATE_INPUT));
        }
    }

    public void nonComma(String input) {
        ArrayList<String> inputData = new ArrayList<>(Arrays.asList(input));

        if (!inputData.contains(",")) {
            throw new IllegalArgumentException(String.valueOf(NON_COMMA));
        }
    }
}
