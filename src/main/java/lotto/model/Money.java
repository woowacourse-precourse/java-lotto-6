package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private static final String MONEY_LESS_THEN_PRIZE = "[ERROR] 금액은 1,000원 이상이어야 합니다.";
    private static final String CANT_DIVIDED_BY_PRIZE =
            "[ERROR] 금액은 1,000원으로 나누어 떨어지는 수어야 합니다.";

    private static final BigDecimal LOTTO_PRIZE = BigDecimal.valueOf(1_000L);
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
    private static final int INITIAL_SCALE = 0;

    private final BigDecimal amount;

    private Money(final long amount) {
        validatePrize(amount);
        validateDivisible(amount);
        this.amount = BigDecimal.valueOf(amount);
    }

    private void validatePrize(final long amount) {
        if (isLessThenPrize(amount)) {
            throw new IllegalArgumentException(MONEY_LESS_THEN_PRIZE);
        }
    }

    private boolean isLessThenPrize(final long amount) {
        return amount < LOTTO_PRIZE.longValue();
    }

    private void validateDivisible(final long amount) {
        if (!isDividedByPrize(amount)) {
            throw new IllegalArgumentException(CANT_DIVIDED_BY_PRIZE);
        }
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
