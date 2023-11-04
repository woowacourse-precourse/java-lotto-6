package lotto.utils;

import lotto.view.ExceptionMessages;

public class Validation {

    public static void validateStringToInteger(String string) {
        if (string.trim().isEmpty() || !string.chars().allMatch(Character::isDigit)) {
            ExceptionMessages.STRING_TO_INTEGER.throwException();
        }
    }

    public static void validateNumberInRange(int number, int min, int max) {
        if (number < min || number > max) {
            ExceptionMessages.NUMBER_IN_RANGE.throwException(min,max);
        }
    }

    public static void validateNumberMultipleOf(int number, int multiple) {
        if (number % multiple != 0) {
            ExceptionMessages.INPUT_MULTIPLE_NUMBER.throwException(multiple);
        }
    }
}
