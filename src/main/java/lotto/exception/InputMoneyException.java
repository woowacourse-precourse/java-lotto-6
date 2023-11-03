package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class InputMoneyException {
    private InputMoneyException() {
    }

    public static void validate(String money) {
        notNumberValidate(money);
        moneyRangeValidate(money);
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

        if (result < 1000 || result > 100_000) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_RANGE.getMessage());
        }
    }
}
