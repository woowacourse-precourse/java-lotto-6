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
        validateAmountRange(amount);
    }

    private void validateDivisibleAmount(int amount) {
        if (isIndivisibleAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

    private boolean isIndivisibleAmount(int amount) {
        return amount % LottoConstraint.PRICE_PER_LOTTO.getValue() != 0;
    }

    private void validateAmountRange(int amount) {
        if (isOutRangeAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_AMOUNT.getMessage());
        }
    }

    private boolean isOutRangeAmount(int amount) {
        return amount < LottoConstraint.MIN_AMOUNT.getValue() || amount > LottoConstraint.MAX_AMOUNT.getValue();
    }

    public int calculatePurchaseLottoCount() {
        return (int) amount / LottoConstraint.PRICE_PER_LOTTO.getValue();
    }
}
