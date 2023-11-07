package lotto.domain;

import lotto.verification.Validation;

public class Money {

    private final long money;

    public Money(long money) {
        Validation.verifyRangeInputMoney(money);
        this.money = money;
    }

    public long getMoney() {
        return this.money;
    }
}
