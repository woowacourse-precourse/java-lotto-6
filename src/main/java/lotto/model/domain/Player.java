package lotto.model.domain;

import static lotto.constants.Error.DIVIDE_INVALID;
import static lotto.constants.Error.MINIMUM_INVALID;
import static lotto.constants.Rule.MIN_MONEY;

public class Player {
    private final int amount;

    public Player(int money) {
        validate(money);
        this.amount = calculateAmount(money);
    }

    public int getAmount() {
        return amount;
    }

    private static void validate(int money) {
        validateMinimumMoney(money);
        validateDivideMoney(money);
    }

    private static void validateMinimumMoney(int money) {
        if (money < MIN_MONEY.getValue()) {
            throw new IllegalArgumentException(MINIMUM_INVALID.getMessage());
        }
    }

    private static void validateDivideMoney(int money) {
        if (money % MIN_MONEY.getValue() != 0) {
            throw new IllegalArgumentException(DIVIDE_INVALID.getMessage());
        }
    }

    private static int calculateAmount(int money) {
        return money / MIN_MONEY.getValue();
    }
}
