package lotto.domain;

public class Amount {
    private static final int AMOUNT_LEAST_VALUE = 1_000;

    private int value;

    public Amount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        isGreaterThanEqualLeastValue(value);
        isMultiple(value);
    }

    private void isGreaterThanEqualLeastValue(int value) {
        if (value < AMOUNT_LEAST_VALUE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1,000원 부터 입니다.");
        }
    }

    private void isMultiple(int value) {
        if (value % AMOUNT_LEAST_VALUE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000의 단위로 입력할 수 있습니다.");
        }
    }
}
