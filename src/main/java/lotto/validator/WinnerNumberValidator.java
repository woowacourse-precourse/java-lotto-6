package lotto.validator;

import lotto.message.ExceptionMessage;

public class WinnerNumberValidator {

    public static void validate(String numbers) {

    }

    private static void validateDividedByComma(String numbers) {
        if (!numbers.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVIDED_BY_COMMA.getMessage());
        }
    }

}
