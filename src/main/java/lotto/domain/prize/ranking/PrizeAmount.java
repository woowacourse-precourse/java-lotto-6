package lotto.domain.prize.ranking;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public enum PrizeAmount {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000),
    ;

    private final long amount;

    PrizeAmount(final long amount) {
        validatePositiveAmount(amount);
        this.amount = amount;
    }

    private void validatePositiveAmount(final long amount) {
        if (amount < 0) {
            throw LottoException.of(ErrorMessage.INVALID_PRIZE_AMOUNT_PRICE_NEGATIVE);
        }
    }

    public long getAmount() {
        return amount;
    }
}
