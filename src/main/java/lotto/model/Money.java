package lotto.model;

import static lotto.model.ErrorType.MONEY_CANT_DIVIDED_BY_PRIZE;
import static lotto.model.ErrorType.MONEY_LESS_THEN_PRIZE;

import java.math.BigDecimal;

public class Money {

    private static final long LOTTO_PRIZE = 1_000L;

    private final BigDecimal amount;

    private Money(final long amount) {
        validate(amount);
        this.amount = BigDecimal.valueOf(amount);
    }

    private void validate(final long amount) {
        if (isLessThenPrize(amount)) {
            throw new IllegalArgumentException(MONEY_LESS_THEN_PRIZE.getMessage());
        }
        if (!isDividedByPrize(amount)) {
            throw new IllegalArgumentException(MONEY_CANT_DIVIDED_BY_PRIZE.getMessage());
        }
    }

    private boolean isLessThenPrize(final long amount) {
        return amount < LOTTO_PRIZE;
    }

    private boolean isDividedByPrize(final long amount) {
        return amount % LOTTO_PRIZE == 0;
    }

    public static Money of(final long amount) {
        return new Money(amount);
    }
}
