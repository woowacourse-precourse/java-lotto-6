package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class InputMoneyException {
    private static final Integer MIN_MONEY = 1000;
    private static final Integer MAX_MONEY = 100_000;
    private static final Integer ZERO = 0;

    private InputMoneyException() {
    }

    public static void moneyValidate(String money) {
        notNumberValidate(money);
        moneyRangeValidate(money);
        moneyUnitValidate(money);
    }

    private static void notNumberValidate(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_RANGE.getMessage());
        }
    }

    private static void moneyRangeValidate(String money) {
        int result = Integer.parseInt(money);

        if (result < MIN_MONEY || result > MAX_MONEY) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_RANGE.getMessage());
        }
    }

    private static void moneyUnitValidate(String money) {
        int result = Integer.parseInt(money);

        if (result % MIN_MONEY != ZERO) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_UNIT.getMessage());
        }
    }
}
