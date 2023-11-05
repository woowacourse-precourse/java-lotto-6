package lotto.domain;

import static lotto.domain.Constants.LOTTO_PRICE;

public class Money {

    int money;

    public Money(int money) {
        this.money = money;
    }

    public int getQuantity() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
