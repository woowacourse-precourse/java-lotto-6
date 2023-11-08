package lotto.model;

import static lotto.constant.CommonUnits.MONEY_UNIT;
import static lotto.constant.ExceptionMessages.WRONG_MONEY_INPUT;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int won) {
        if (won % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(WRONG_MONEY_INPUT);
        }
    }
}
