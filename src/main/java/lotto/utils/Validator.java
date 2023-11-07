package lotto.utils;

import static lotto.message.ErrorMessage.*;

public class Validator {
    private static final int MONEY_UNIT = 1000;

    private static void checkDivisibleByMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
        }
    }

    private static void checkExistOfValue(String inputValue) {
        String input = inputValue.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EXIST_OF_VALUE_ERROR.getMessage());
        }
    }

    private int checkNumericInput(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INPUT_ERROR.getMessage());
        }
    }

    private static void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }
}
