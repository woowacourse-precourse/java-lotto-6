package lotto.util.validator;

import lotto.util.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberValidator {
    public static final int MIN_RANDOM_BOUND = 1;
    public static final int MAX_RANDOM_BOUND = 45;
    public static final int TOTAL_COUNT = 6;

    private static void validateNullorEmpty(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_WINNING_NUMBERS.getMessage());
        }
    }

    private static void validateNumberCount(String[] numberStrings) {
        if (numberStrings.length != TOTAL_COUNT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private static List<Integer> validateNumberFormate(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorCode.INVALID_WINNING_NUMBER_FORMAT.getMessage());
            }
        }
        return numbers;
    }
}
