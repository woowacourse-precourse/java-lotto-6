package lotto.validator;

import static lotto.constants.ErrorCode.NOT_INTEGER;

public class Validator {

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }
}
