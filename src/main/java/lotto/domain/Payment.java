package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstraint;

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
        return amount % LottoConstraint.PRICE_PER_LOTTO.getValue() != 0;
    }

    private void validateAmountRange(long amount) {
        if (isOutRangeAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_AMOUNT.getMessage());
        }
    }

    private boolean isOutRangeAmount(long amount) {
        long pricePerLotto = LottoConstraint.PRICE_PER_LOTTO.getValue();
        long minAmount = pricePerLotto * LottoConstraint.MIN_PURCHASE_QUANTITY.getValue();
        long maxAmount = pricePerLotto * LottoConstraint.MAX_PURCHASE_QUANTITY.getValue();
        return amount < minAmount || amount > maxAmount;
    }

    public int calculatePurchaseLottoCount() {
        return (int) (amount / LottoConstraint.PRICE_PER_LOTTO.getValue());
    }

    long getAmount() {
        return amount;
    }
}
