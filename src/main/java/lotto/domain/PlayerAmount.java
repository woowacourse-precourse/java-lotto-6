package lotto.domain;

import lotto.util.Validator;

public class PlayerAmount {
    private static final int DIVISOR = 1000;
    private final int amount;

    public PlayerAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public PlayerAmount(String inputAmount) {
        this(Validator.validateNumeric(inputAmount));
    }

    private void validate(int amount) {
        Validator.validateDivisibleBy(amount, DIVISOR);
    }

    public int getLottoCount() {
        return amount / DIVISOR;
    }
}
