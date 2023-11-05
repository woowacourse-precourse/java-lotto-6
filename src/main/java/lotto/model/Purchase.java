package lotto.model;

import static lotto.util.message.Error.MUST_MONEY_UNIT;

public class Purchase {

    private final static int MONEY_UNIT = 1000;
    private final int money;
    private final int count;

    public Purchase(int money) {
        validate(money);
        this.money = money;
        this.count = money / 10;
    }

    private void validate(int money) {
        if (money % MONEY_UNIT != 0 || money <= 0) {
            throw new IllegalArgumentException(MUST_MONEY_UNIT);
        }
    }
}
