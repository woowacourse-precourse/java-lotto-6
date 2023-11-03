package lotto.domain;

import lotto.ui.message.ErrorMessage;

public class Money {

    private final Integer amount;

    public Money(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_THOUSAND.getComment());
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_THOUSAND_UNIT.getComment());
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
