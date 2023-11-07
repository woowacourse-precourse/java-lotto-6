package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Constants;

public class Payment {
    private final long amount;

    public Payment(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        validateDivisibleAmount(amount);
        validateAmountRange(amount);
    }

    private void validateDivisibleAmount(long amount) {
        if (isIndivisibleAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

    private boolean isIndivisibleAmount(long amount) {
        return amount % Constants.LOTTO_PRICE != 0;
    }

    private void validateAmountRange(long amount) {
        if (isOutRangeAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_AMOUNT.getMessage());
        }
    }

    private boolean isOutRangeAmount(long amount) {
        return amount < Constants.MIN_AMOUNT || amount > Constants.MAX_AMOUNT;
    }

    public int calculatePurchaseLottoCount() {
        return (int) (amount / Constants.LOTTO_PRICE);
    }

    long getAmount() {
        return amount;
    }
}