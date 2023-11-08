package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

public class LottoPurchaseAmount {
    private final String input;

    public LottoPurchaseAmount(String input) {
        validate(input);
        this.input = input;
    }

    private void validate(String input) {
        new LottoPurchaseAmountException(input);
    }

    public int getCount() {
        return Integer.parseInt(input);
    }
}
