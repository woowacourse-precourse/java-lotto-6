package lotto.model;

import lotto.validate.MoneyValidate;

public class Money {

    private final int money;

    public Money(int money) {
        MoneyValidate.validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
