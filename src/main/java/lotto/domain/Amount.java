package lotto.domain;

import lotto.validator.MoneyValidator;

public class Amount {

    private static final int UNIT = 1000;
    private final int money;
    public Amount(int money) {
        MoneyValidator.validate(money);
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / UNIT;
    }
}
