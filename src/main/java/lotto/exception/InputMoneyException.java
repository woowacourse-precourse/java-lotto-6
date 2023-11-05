package lotto.exception;

import static lotto.exception.ErrorMessage.*;
import static lotto.util.NumberConstant.*;

public class InputMoneyException {
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

        if (result < MONEY_STANDARD || result > MONEY_MAX) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_RANGE.getMessage());
        }
    }

    private static void moneyUnitValidate(String money) {
        int result = Integer.parseInt(money);

        if (result % MONEY_STANDARD != 0) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_UNIT.getMessage());
        }
    }
}
