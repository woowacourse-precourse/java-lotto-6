package lotto.validator;

import lotto.message.ExceptionMessage;

public class BonusNumberValidator {
    public static void validate(String inputNumber) {
        validateNaturalNumber(inputNumber);
    }

    private static void validateNaturalNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

}
