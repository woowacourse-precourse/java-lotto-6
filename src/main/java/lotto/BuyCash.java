package lotto;

public class BuyCash {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String NOT_DIVIDED_MESSAGE = "구매금액이 1000원으로 나눠지지 않습니다.";
    private static final String NOT_POSITIVE_MESSAGE = "구매금액은 양수여야 합니다.";
    private static final int BUY_UNIT = 1000;
    private final long buyCash;

    public BuyCash(long buyCash) {
        validate(buyCash);
        this.buyCash = buyCash;
    }

    private void validate(long buyCash) {
        if (isNotPositive(buyCash)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_POSITIVE_MESSAGE);
        }

        if (isNotDividedByUnit(buyCash)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_DIVIDED_MESSAGE);
        }
    }

    private boolean isNotDividedByUnit(long buyCash) {
        return buyCash % BUY_UNIT != 0;
    }

    private boolean isNotPositive(long buyCash) {
        return buyCash < 0;
    }

    public long getLottoAmount() {
        return buyCash / BUY_UNIT;
    }

    public double getTotalProfitRate(long totalProfit) {
        return (double) totalProfit / buyCash * 100;
    }
}
