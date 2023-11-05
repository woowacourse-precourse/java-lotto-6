package lotto.model;

import static lotto.model.ErrorType.MONEY_CANT_DIVIDED_BY_PRIZE;
import static lotto.model.ErrorType.MONEY_LESS_THEN_PRIZE;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private static final BigDecimal LOTTO_PRIZE = BigDecimal.valueOf(1_000L);
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
    private static final int INITIAL_SCALE = 0;

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
        return amount < LOTTO_PRIZE.longValue();
    }

    private boolean isDividedByPrize(final long amount) {
        return amount % LOTTO_PRIZE.longValue() == 0;
    }

    public static Money of(final long amount) {
        return new Money(amount);
    }

    public long calculateTicketCount() {
        return amount.divide(LOTTO_PRIZE, INITIAL_SCALE, DEFAULT_ROUNDING).longValue();
    }
}
