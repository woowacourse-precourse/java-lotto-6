package lotto.domain;

import lotto.validator.impl.MoneyValidator;

public class Money {
    private int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    void validate(String money) {
        new MoneyValidator().validate(money);
    }

    public int getMoney() {
        return money;
    }
}
