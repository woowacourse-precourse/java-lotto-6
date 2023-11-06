package lotto.domain;

import lotto.validator.MoneyValidator;

public class Amount {

    private static final int UNIT = 1000;
    private final int money;
    private final MoneyValidator moneyValidator = new MoneyValidator();
    public Amount(int money) {
        moneyValidator.validate(money);
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / UNIT;
    }
}
