package lotto.utils;

import java.math.BigDecimal;

public class MoneyParser {
    private static String MONEY_REGEX = "^[1-9]\\d*$";
    private static String IMPROPER_MONEY_MESSAGE = "금액을 올바르게 입력하세요.";
    private static String EMPTY_INPUT_MESSAGE = "입력값이 없습니다.";

    public static BigDecimal parseMoney(String inputMoney) {
        validateEmptyString(inputMoney);
        validateMoney(inputMoney);
        try {
            return new BigDecimal(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IMPROPER_MONEY_MESSAGE);
        }
    }

    private static void validateMoney(String inputMoney) {
        if (!inputMoney.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException(IMPROPER_MONEY_MESSAGE);
        }
    }

    private static void validateEmptyString(String inputNumber) {
        if (inputNumber == null || inputNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }
}
