package lotto.model.lotto;

import static lotto.constants.Error.DIVIDE_INVALID;
import static lotto.constants.Error.MINIMUM_INVALID;
import static lotto.constants.Rule.MIN_MONEY;

public class PlayerAmount {
    private final int amount;

    private PlayerAmount(int amount) {
        this.amount = amount;
    }

    public static PlayerAmount getInstance(int money) {
        validate(money);
        return new PlayerAmount(calculateAmount(money));
    }

    private static void validate(int money) {
        validateMinimum(money);
        validateDivide(money);
    }

    private static void validateMinimum(int money) {
        if (money < MIN_MONEY.getValue()) {
            throw new IllegalArgumentException(MINIMUM_INVALID.getMessage());
        }
    }

    private static void validateDivide(int money) {
        if (money % MIN_MONEY.getValue() != 0) {
            throw new IllegalArgumentException(DIVIDE_INVALID.getMessage());
        }
    }

    private static int calculateAmount(int money) {
        return money / MIN_MONEY.getValue();
    }

    public int getAmount() {
        return amount;
    }
}
