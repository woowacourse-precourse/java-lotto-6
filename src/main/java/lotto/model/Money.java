package lotto.model;

import lotto.util.validator.MoneyValidator;

public class Money {
    private final int money;

    public Money(String money) {
        new MoneyValidator(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
}
