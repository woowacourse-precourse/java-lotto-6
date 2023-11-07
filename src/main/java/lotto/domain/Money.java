package lotto.domain;

import lotto.domain.validator.MoneyValidator;

public class Money {
    private final Integer amount;

    public Money(Integer amount) {
        new MoneyValidator(amount);
        this.amount = amount;
    }
}
