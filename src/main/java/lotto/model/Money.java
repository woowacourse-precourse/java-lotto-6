package lotto.model;

import static lotto.model.LottoErrorType.MONEY_CANT_DIVIDED_BY_PRIZE;
import static lotto.model.LottoErrorType.MONEY_LESS_THAN_PRIZE;

import java.math.BigDecimal;

public class Money {

    private static final long LOTTO_PRIZE = 1000L;

    private final long amount;

    private Money(final long amount) {
        validatePrize(amount);
        validateDivisible(amount);
        this.amount = amount;
    }

    private void validatePrize(final long amount) {
        if (isLessThanPrize(amount)) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_PRIZE.getMessage());
        }
    }

    private boolean isLessThanPrize(final long amount) {
        return amount < LOTTO_PRIZE;
    }

    private void validateDivisible(final long amount) {
        if (!isDivisibleWithPrize(amount)) {
            throw new IllegalArgumentException(MONEY_CANT_DIVIDED_BY_PRIZE.getMessage());
        }
    }

    private boolean isDivisibleWithPrize(final long amount) {
        return amount % LOTTO_PRIZE == 0;
    }

    public static Money of(final long amount) {
        return new Money(amount);
    }

    public long calculateTicketCount() {
        return amount / LOTTO_PRIZE;
    }

    public BigDecimal getAmount() {
        return new BigDecimal(amount);
    }
}
