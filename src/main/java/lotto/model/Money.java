package lotto.model;

public class Money {

    private static final String MONEY_LESS_THEN_PRIZE = "[ERROR] 금액은 1,000원 이상이어야 합니다.";
    private static final String CANT_DIVIDED_BY_PRIZE =
            "[ERROR] 금액은 1,000원으로 나누어 떨어지는 수어야 합니다.";

    private static final long LOTTO_PRIZE = 1000L;

    private final long amount;

    private Money(final long amount) {
        validatePrize(amount);
        validateDivisible(amount);
        this.amount = amount;
    }

    private void validatePrize(final long amount) {
        if (isLessThenPrize(amount)) {
            throw new IllegalArgumentException(MONEY_LESS_THEN_PRIZE);
        }
    }

    private boolean isLessThenPrize(final long amount) {
        return amount < LOTTO_PRIZE;
    }

    private void validateDivisible(final long amount) {
        if (!isDividedByPrize(amount)) {
            throw new IllegalArgumentException(CANT_DIVIDED_BY_PRIZE);
        }
    }

    private boolean isDividedByPrize(final long amount) {
        return amount % LOTTO_PRIZE == 0;
    }

    public static Money of(final long amount) {
        return new Money(amount);
    }

    public long calculateTicketCount() {
        return amount / LOTTO_PRIZE;
    }
}
