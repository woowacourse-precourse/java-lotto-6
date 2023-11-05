package lotto.domain.constants;

public enum LottoConstraint {
    LOTTO_PRICE(1000),

    NUMBER_RANGE_MINIMUM(1),
    NUMBER_RANGE_MAXIMUM(45);

    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
