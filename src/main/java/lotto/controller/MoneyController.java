package lotto.controller;

import lotto.model.Money;

public class MoneyController {
    public Money create(int money) {
        return new Money(money);
    }
}
