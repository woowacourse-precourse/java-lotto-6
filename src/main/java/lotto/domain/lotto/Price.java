package lotto.domain.lotto;

import static lotto.io.ErrorMessage.PRICE_CANNOT_DIVIDE;
import static lotto.io.ErrorMessage.PRICE_OUT_OF_RANGE;

public class Price {
    private static final long MIN_AMOUNT = 1000L;
    private static final long MAX_AMOUNT = 100000L;
    private static final long DIVIDE_UNIT = 1000L;

    private final long amount;

    public Price(long amount) {
        validateRange(amount);
        validateUnitDivision(amount);
        this.amount = amount;
    }

    private void validateRange(long amount) {
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(PRICE_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateUnitDivision(long amount) {
        if (amount % DIVIDE_UNIT != 0) {
            throw new IllegalArgumentException(PRICE_CANNOT_DIVIDE.getMessage());
        }
    }
}
