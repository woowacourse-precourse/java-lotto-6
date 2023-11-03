package domain;

import validator.MoneyValidator;

public class Money {
    private final long money;

    public Money(String money) {
        validate(money);
        this.money = Long.parseLong(money);
    }

    private void validate(String money) {
        MoneyValidator.isNumeric(money);
        MoneyValidator.isZero(money);
        MoneyValidator.isThousandUnit(money);
    }

    public long getMoney() {
        return money;
    }
}
