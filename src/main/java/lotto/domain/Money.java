package lotto.domain;

import lotto.util.validator.MoneyValidator;

public class Money {
    private final int money;

    Money(String money) {
        new MoneyValidator(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
}
