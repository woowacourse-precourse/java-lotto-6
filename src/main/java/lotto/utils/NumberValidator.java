package lotto.utils;

import lotto.message.ErrorMessage;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final String REGEX = "[0-9]+";
    public static void validate(String userInput) {
        validateIsNumber(userInput);
        validateIsRange(userInput);
    }

    private static void validateIsNumber(String userInput) {
        if (!Pattern.matches(REGEX, userInput)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER.getMessage());
        }
    }

    private static void validateIsRange(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_ARRANGE.getMessage());
        }
    }
}
