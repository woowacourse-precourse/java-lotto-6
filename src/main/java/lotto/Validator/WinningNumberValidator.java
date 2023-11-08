package lotto.Validator;

import java.util.HashSet;
import java.util.Set;
import lotto.Exception.WinningNumberErrorMessage;

public class WinningNumberValidator {
    private static final String COMMA_SEPARATOR = ",";
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;

    public static String validateWinningNumber(String input) {
        String[] numbers = input.split(COMMA_SEPARATOR);

        validateNumberRange(numbers);

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

}
