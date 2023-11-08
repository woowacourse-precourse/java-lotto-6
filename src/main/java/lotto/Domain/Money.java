package lotto.Domain;

import lotto.Function.Validate;

public class Money {
    public static final int ZERO = 0;
    public static final int THOUSAND = 1000;
    public final int money;

    public Money(int money) {
        Validate.validateMoney(money);
        this.money = money;
    }

    public int getTicket() {
        return money / THOUSAND;
    }

    public int getMoney() {
        return money;
    }
}
