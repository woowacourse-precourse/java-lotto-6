package lotto.domain;

import lotto.execption.MoneyException;

public class Money {
    private static final Integer ZERO = 0;
    private static final Integer THOUSAND =1000;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= ZERO || money % THOUSAND != 0) {
            throw new MoneyException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return money / THOUSAND;
    }
}
