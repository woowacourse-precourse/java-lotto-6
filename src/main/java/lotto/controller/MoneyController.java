package lotto.controller;

import lotto.domain.Money;

public class MoneyController {
    public Money create(int money) {
        return new Money(money);
    }
}
