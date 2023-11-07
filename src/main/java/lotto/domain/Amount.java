package lotto.domain;

import lotto.utils.Validation;

public record Amount(int amount) {

    public Amount {
        validate(amount);
    }

    private void validate(int amount) {
        Validation.validatePurchaseAmount(amount);
    }
}
