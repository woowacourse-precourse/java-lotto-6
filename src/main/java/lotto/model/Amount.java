package lotto.model;

import static lotto.util.message.Error.MUST_MONEY_UNIT;

public class Amount {

    private final static int MONEY_UNIT = 1000;
    private final int money;

    public Amount(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % MONEY_UNIT != 0 || money <= 0) {
            throw new IllegalArgumentException(MUST_MONEY_UNIT);
        }
    }
}
