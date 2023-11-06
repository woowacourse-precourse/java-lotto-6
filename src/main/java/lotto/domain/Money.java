package lotto.domain;

import lotto.execption.MoneyException;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new MoneyException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return money / 1000;
    }
}
