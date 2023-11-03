package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class InputMoneyException {
    private InputMoneyException() {
    }

    public static void validate(String money) {
        notNumberValidate(money);
    }

    private static void notNumberValidate(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR.getMessage() + MONEY_RANGE.getMessage());
        }
    }

    private static void moneyMaxOverValidate(String money) {

    }
}
