package lotto.utils;

import static lotto.constant.ExceptionMessage.INVALID_BLANK_EXCEPTION;
import static lotto.constant.ExceptionMessage.INVALID_NUMBER_EXCEPTION;
import static lotto.constant.Global.DIGIT_REGEX;

import java.util.Arrays;

public class InputValidator {
    public static void validateInputMoney(String money) {
        if (isNotDigit(money)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION.getMessage());
        }
    }

    public static void validateInputWinningNumber(String[] inputWinningNumber) {
        if (isBlankWinningNumber(inputWinningNumber)) {
            throw new IllegalArgumentException(INVALID_BLANK_EXCEPTION.getMessage());
        }

        if (checkDigitWinningNumber(inputWinningNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION.getMessage());
        }
    }

    private static boolean isBlankWinningNumber(String[] inputWinningNumber) {
        return Arrays.stream(inputWinningNumber)
                .anyMatch(String::isBlank);
    }

    private static boolean checkDigitWinningNumber(String[] inputWinningNumber) {
        return Arrays.stream(inputWinningNumber)
                .anyMatch(InputValidator::isNotDigit);
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (isBlankBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BLANK_EXCEPTION.getMessage());
        }

        if (isNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION.getMessage());
        }
    }

    private static boolean isBlankBonusNumber(String input) {
        return input.isBlank();
    }

    private static boolean isNotDigit(String input) {
        return !input.matches(DIGIT_REGEX.getValue());
    }
}
