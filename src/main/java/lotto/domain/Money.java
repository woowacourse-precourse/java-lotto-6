package lotto.domain;

public class Money {
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1000 이상의 숫자만 입력 가능합니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "[ERROR] 1000원 단위로만 구매가 가능합니다.";

    private final long amount;

    public Money(long amount) {
        validateRange(amount);
        validateDivisibleBy1000(amount);

        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public int getDividedBy1000() {
        return (int) (amount / 1_000);
    }

    private void validateRange(long amount) {
        if (amount <= 1_000) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDivisibleBy1000(long amount) {
        if (amount % 1_000 != 0) {
            throw new IllegalArgumentException(DIVIDE_ERROR_MESSAGE);
        }
    }
}
