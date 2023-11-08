package lotto.Validator;

import java.util.HashSet;
import java.util.Set;
import lotto.Exception.WinningNumberErrorMessage;

public class WinningNumberValidator {
    private static final String COMMA_SEPARATOR = ",";
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;
    private static final int BLANK_NUMBER = 0;
    private static final int LIMITED_NUMBER = 7;
    private static final int USE_INVALID_SIGN = 1;

    public static String validateWinningNumber(String input) {
        String[] numbers = input.split(COMMA_SEPARATOR);

        validateNumberRange(numbers);
        validateNumberOfNumbers(numbers);
        validateNumberFormat(numbers);
        validateDuplicateNumbers(numbers);

        return input;
    }

    private static void validateNumberRange(String[] numbers) {
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            if (number < MINIMUM_VALUE || number > MAXIMUM_VALUE) {
                throw new IllegalArgumentException(WinningNumberErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static void validateNumberOfNumbers(String[] numbers) {
        if (numbers.length == BLANK_NUMBER) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.NO_WINNING_NUMBER_ENTERED.getMessage());
        }
        if (numbers.length > LIMITED_NUMBER) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.TOO_MANY_WINNING_NUMBERS.getMessage());
        }
    }

    private static void validateNumberFormat(String[] numbers) {
        if (numbers.length == USE_INVALID_SIGN) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
        for (String numberStr : numbers) {
            if (numberStr.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
            }
        }
    }

    private static void validateDuplicateNumbers(String[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(WinningNumberErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
            }
            uniqueNumbers.add(number);
        }
    }

}
