package lotto.controller;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.ErrorConstants.OVER_RANGE;

import lotto.util.ErrorConstants;

public class InputValidator {
    private static void inputIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorConstants.BLANK);
        }
    }

    private static int isInteger(String input) {
        inputIsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.OVER_INTEGER);
        }
    }

    private static void isThousandUnit(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNIT);
        }
    }

    private static void isNumberInRange(String number) {
        int num = isInteger(number);
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException(OVER_RANGE);
        }
    }

    private static void isCommaSeparated(String input) {
        if (!input.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException(ErrorConstants.INADEQUATE_INPUT);
        }
    }

    public static boolean validatePurchaseAmount(String input) {
        isInteger(input);
        isThousandUnit(input);
        return true;
    }

    public static boolean validateWinningNumbers(String input) {
        isCommaSeparated(input);
        return true;
    }

    public static boolean validateBonusNumber(String bonusNumber, String winningNumbers) {
        return true;
    }

}
