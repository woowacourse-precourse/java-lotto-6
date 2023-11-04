package lotto.utils;

import lotto.view.ExceptionMessages;

public class Validation {

    public static void validateStringToInteger(String string) {
        if (string.trim().isEmpty() || !string.chars().allMatch(Character::isDigit)) {
            ExceptionMessages.STRING_TO_INTEGER.throwException();
        }
    }
}
