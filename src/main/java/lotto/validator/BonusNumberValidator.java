package lotto.validator;

import lotto.message.ExceptionMessage;

public class BonusNumberValidator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    public static void validate(String inputNumber) {
        validateNaturalNumber(inputNumber);
        validateNumberInRange(inputNumber);
    }

    private static void validateNaturalNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static void validateNumberInRange(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

}
