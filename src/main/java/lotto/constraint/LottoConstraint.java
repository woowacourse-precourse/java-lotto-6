package lotto.constraint;

public enum LottoConstraint {
    TOTAL_NUMBERS_OF_LOTTO(6),
    LOTTO_MINIMUM_BOUND(1),
    LOTTO_MAXIMUM_BOUND(45);

    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}