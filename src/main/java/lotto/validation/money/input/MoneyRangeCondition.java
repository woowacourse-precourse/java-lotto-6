package lotto.validation.money.input;

import lotto.validation.ValidationCondition;

public class MoneyRangeCondition extends ValidationCondition {
    private static final Integer INT_MAX = Integer.MAX_VALUE;
    private static final String EXCEPTION_MSG = "금액이 범위를 확인해주세요.";

    @Override
    protected void validateCondition(Object obj) {
        try {
            validateIntegerRange((String) obj);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);

        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof String;
    }

    private static void validateIntegerRange(String moneyString) {
        int money = Integer.parseInt(moneyString);

        if (money <= 0 || money > INT_MAX) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }


}
