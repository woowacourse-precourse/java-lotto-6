package domain;

import validator.MoneyValidator;

public class Money {
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        MoneyValidator.isNumeric(money);
        MoneyValidator.isZero(money);
        MoneyValidator.isThousandUnit(money);
    }

    public int getMoney() {
        return money;
    }
}
