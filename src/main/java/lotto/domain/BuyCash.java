package lotto.domain;

import lotto.util.ExceptionMessageGenerator;

public class BuyCash {
    private static final int BUY_UNIT = 1000;
    private static final int ZERO = 0;
    private static final int PERCENT = 100;
    private static final String NOT_DIVIDED_MESSAGE = String.format("구매금액이 %d원으로 나눠지지 않습니다.", BUY_UNIT);
    private static final String NOT_POSITIVE_MESSAGE = "구매금액은 양수여야 합니다.";

    private final long buyCash;

    public BuyCash(long buyCash) {
        validate(buyCash);
        this.buyCash = buyCash;
    }

    private void validate(long buyCash) {
        ExceptionMessageGenerator exceptionMessageGenerator = ExceptionMessageGenerator.INSTANCE;

        if (isNotPositive(buyCash)) {
            throw new IllegalArgumentException(exceptionMessageGenerator.makeMessage(NOT_POSITIVE_MESSAGE));
        }
        if (isNotDividedByUnit(buyCash)) {
            throw new IllegalArgumentException(exceptionMessageGenerator.makeMessage(NOT_DIVIDED_MESSAGE));
        }
    }

    private boolean isNotDividedByUnit(long buyCash) {
        return buyCash % BUY_UNIT != ZERO;
    }

    private boolean isNotPositive(long buyCash) {
        return buyCash <= ZERO;
    }

    public long getLottoAmount() {
        return buyCash / BUY_UNIT;
    }

    public double getTotalProfitRate(long totalProfit) {
        return (double) totalProfit / buyCash * PERCENT;
    }
}
