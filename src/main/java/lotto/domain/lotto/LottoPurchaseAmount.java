package lotto.domain.lotto;

import java.util.Objects;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public final class LottoPurchaseAmount {

    private final long amount;

    public LottoPurchaseAmount(final long amount) {
        validatePositiveNumber(amount);
        validateDividableByCriteria(amount);
        this.amount = amount;
    }

    private void validatePositiveNumber(final long amount) {
        if (amount < 0) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_PRICE_NEGATIVE);
        }
    }

    private void validateDividableByCriteria(final long amount) {
        final long amountRemainder = amount % LottoPrice.ONE.getPrice();
        if (amountRemainder > 0) {
            throw LottoException.of(ErrorMessage.INVALID_PURCHASING_AMOUNT_NOT_DIVIDED);
        }
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (!(other instanceof LottoPurchaseAmount otherLottoPurchaseAmount)) {
            return false;
        }

        return Objects.equals(amount, otherLottoPurchaseAmount.amount);
    }
}
