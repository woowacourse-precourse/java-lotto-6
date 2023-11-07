package lotto.input;

import java.util.Arrays;

import static lotto.GameConfig.*;

public class InputValidator {
    public static void validateBonusNumberInput(String input) {
        validateIsInteger(input);
    }

    public static void validatePurchaseMoneyInput(String input) {
        validateIsInteger(input);
        validatePurchaseMoneyUnit(input);
    }

    public static void validateWinningNumberInput(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        Arrays.stream(separatedInput)
                .forEach(InputValidator::validateIsInteger);
    }

    private static void validatePurchaseMoneyUnit(String input) {
        if (!isMultipleOfUnit(Integer.parseInt(input))) {
            throw new IllegalArgumentException("최소 단위는 ~입니다.");
        }
    }

    private static boolean isMultipleOfUnit(int input) {
        return input % PURCHASE_MONEY_UNIT == 0;
    }

    private static void validateIsInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 정수여야합니다.");
        }
    }
}
