package lotto.domain;

import static lotto.util.Instruction.ERROR_INPUT_MONEY;
import static lotto.util.Instruction.ERROR_MULTIPLE_MONEY;

public class Money {
    private static final int MINIMUM_AMOUNT = 1000;
    private final int money;

    public Money(final String money) {
        isValidMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void isValidMoney(final String money) {
        checkValidInt(money);
        checkMoreThanMinimumAmount(Integer.parseInt(money));
        checkMultiple(Integer.parseInt(money));
    }

    private void checkValidInt(final String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY.getMessage());
        }
    }

    private void checkMoreThanMinimumAmount(final int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY.getMessage());
        }
    }

    private void checkMultiple(final int money) {
        if (money % MINIMUM_AMOUNT != 0) {
            throw new IllegalArgumentException(ERROR_MULTIPLE_MONEY.getMessage());
        }
    }
}
