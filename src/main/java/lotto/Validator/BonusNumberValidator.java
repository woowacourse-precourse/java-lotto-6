package lotto.Validator;

import lotto.Exception.BonusNumberErrorMessage;

public class BonusNumberValidator {
    private static final String COMMA_SEPARATOR = ",";
    private static final int BLANK_NUMBER = 0;
    private static final int LIMITED_NUMBER = 1;

    public static String validateBonusNumber(String input) {
        validateNoBonusNumberEntered(input);
        validateTooManyBonusNumbers(input);
        return input;
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

