package lotto.domain;

public class TotalAmount {
    private static final long MINIMUM_AMOUNT = 0L;

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
            throw new IllegalStateException();
        }
    }

    public long getTotalAmount() {
        return totalAmount;
    }
}
