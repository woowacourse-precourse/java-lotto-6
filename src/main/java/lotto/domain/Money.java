package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {
    private final String money;

    public Money(String money) {
        validate(money);
        this.money = money;
    }

    private void validate(String input) {
        MoneyValidator.validate(input);
    }

    public int getTryNumber() {
        return Integer.parseInt(this.money) / 1000;
    }

    public int getMoney() {
        return Integer.parseInt(this.money);
    }


}
