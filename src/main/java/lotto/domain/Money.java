package lotto.domain;

import lotto.constraints.ErrorMessage;

public record Money(
        int money
) {
    public Money {
        validate(money);
    }

    private void validate(int input) {
        if (input < NumberConstraints.PER_PRICE.value()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }
}
