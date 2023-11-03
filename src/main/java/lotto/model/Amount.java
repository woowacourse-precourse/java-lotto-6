package lotto.model;

import lotto.validator.AmountValidator;

public class Amount {
    private int money;

    public Amount(int money) {
        AmountValidator.validateAmount(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
