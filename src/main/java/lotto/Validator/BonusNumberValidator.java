package lotto.Validator;

import lotto.Exception.BonusNumberErrorMessage;
import lotto.Exception.WinningNumberErrorMessage;

public class BonusNumberValidator {
    private static final String COMMA_SEPARATOR = ",";
    private static final int BLANK_NUMBER = 0;
    private static final int LIMITED_NUMBER = 1;
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;

    public static String validateBonusNumber(String input) {
        validateNumberRange(input);
        validateNoBonusNumberEntered(input);
        validateTooManyBonusNumbers(input);
        return input;
    }

    private static void validateNumberRange(String input) {
        String[] numbers = input.split(COMMA_SEPARATOR);

        if (numbers.length == LIMITED_NUMBER) {
            int bonusNumber = Integer.parseInt(numbers[0]);
            if (bonusNumber < MINIMUM_VALUE || bonusNumber > MAXIMUM_VALUE) {
                throw new IllegalArgumentException(BonusNumberErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static void validateNoBonusNumberEntered(String input) {
        String[] numbers = input.split(COMMA_SEPARATOR);
        if (numbers.length == BLANK_NUMBER) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.NO_BONUS_NUMBER_ENTERED.getMessage());
        }
    }

    private static void validateTooManyBonusNumbers(String input) {
        String[] numbers = input.split(COMMA_SEPARATOR);
        if (numbers.length > LIMITED_NUMBER) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.TOO_MANY_BONUS_NUMBERS.getMessage());
        }
    }
}

