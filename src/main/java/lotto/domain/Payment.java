package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstraint;

public class Payment {
    private final long amount;

    public Payment(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateDivisibleAmount(amount);
    }

    private void validateDivisibleAmount(int amount) {
        if (isIndivisibleAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

    private boolean isIndivisibleAmount(int amount) {
        return amount % LottoConstraint.PRICE_PER_LOTTO.getValue() != 0;
    }

    public int calculatePurchaseLottoCount() {
        return 0;
    }
}
