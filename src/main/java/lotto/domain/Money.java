package lotto.domain;

import lotto.domain.validator.MoneyValidator;

public class Money {
    private final Integer amount;

    public Money(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        new MoneyValidator(amount);
    }
    public Integer calculateLottoCount() {
        return amount / 1000;
    }
}
