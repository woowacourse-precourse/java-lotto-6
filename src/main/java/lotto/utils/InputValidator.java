package lotto.utils;

import java.util.Arrays;

public class InputValidator {
    public static void validateInputMoney(String money) {
        if (isNotDigit(money)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static void validateInputWinningNumber(String[] inputWinningNumber) {
        if (isBlankWinningNumber(inputWinningNumber)) {
            throw new IllegalArgumentException("공백은 입력될 수 없습니다.");
        }

        if (checkDigitWinningNumber(inputWinningNumber)) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 입력 가능합니다.");
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
            throw new IllegalArgumentException("공백은 입력될 수 없습니다.");
        }

        if (isNotDigit(bonusNumber)) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 입력 가능합니다.");
        }
    }

    private static boolean isBlankBonusNumber(String input) {
        return input.isBlank();
    }

    private static boolean isNotDigit(String input) {
        return !input.matches("^[0-9]+$");
    }
}
