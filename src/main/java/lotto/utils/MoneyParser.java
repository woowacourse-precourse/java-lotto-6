package lotto.utils;

import java.math.BigDecimal;

public class MoneyParser {
    private static final String IMPROPER_MONEY_MESSAGE = "금액을 올바르게 입력하세요.";

    public static BigDecimal parseMoney(String inputMoney) {
        CommonValidator.validateEmptyString(inputMoney);
        AmountValidator.validateMoney(inputMoney);
        try {
            return new BigDecimal(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IMPROPER_MONEY_MESSAGE);
        }
    }
}
