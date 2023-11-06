package lotto.domain;

public class TotalAmount {
    private static final long MINIMUM_AMOUNT = 0L;
    private static final String OVERFLOW_ERROR_MESSAGE = "오버플로우가 발생하였습니다.";

    private final long totalAmount;

    public TotalAmount(long totalAmount) {
        validate(totalAmount);
        this.totalAmount = totalAmount;
    }

    private void validate(long money) {
        validateOverflow(money);
    }

    private void validateOverflow(long money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalStateException(OVERFLOW_ERROR_MESSAGE);
        }
    }

    public long getTotalAmount() {
        return totalAmount;
    }
}
