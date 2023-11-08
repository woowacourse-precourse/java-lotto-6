package lotto.util;

import static lotto.message.ErrorMessage.*;

public class Validator {
    private static final int MONEY_UNIT = 1000;

    public static void validateLottoPurchaseAmount(String money) {
        checkDivisibleByMoneyUnit(money);
        checkExistOfValue(money);
        checkNegativeNumber(money);
    }

    private static void checkDivisibleByMoneyUnit(String inputValue) {
        int inputNum = Integer.parseInt(inputValue);
        if (inputNum % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
        }
    }

    private static void checkExistOfValue(String inputValue) {
        String input = inputValue.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EXIST_OF_VALUE_ERROR.getMessage());
        }
    }

    private static void checkNegativeNumber(String inputValue) {
        int inputNum = Integer.parseInt(inputValue);
        if (inputNum < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }
}
