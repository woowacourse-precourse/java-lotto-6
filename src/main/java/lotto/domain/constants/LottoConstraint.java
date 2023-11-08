package lotto.domain.constants;

public enum LottoConstraint {

    LOTTO_PRICE(1000),
    LOTTO_NUMBER_COUNT(6),
    LOWER_BOUND(1),
    UPPER_BOUND(45),
    BONUS_COUNT(1);
    private final int value;

    LottoConstraint(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
