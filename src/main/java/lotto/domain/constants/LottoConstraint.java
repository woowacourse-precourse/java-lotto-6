package lotto.domain.constants;

public enum LottoConstraint {

    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    BONUS_COUNT(1);
    private final int value;

    LottoConstraint(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
