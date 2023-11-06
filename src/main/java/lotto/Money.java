package lotto;

import Exception.MoneyFormatException;

public class Money {
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) {
        if (money % THOUSAND != 0) {
            throw new MoneyFormatException();
        }
    }
}
