package lotto.domain.enums;

public enum LottoConstraint {
    LOTTO_UNIT_PRICE(1000),
    START_RANGE_NUMBER(1),
    END_RANGE_NUMBER(45),
    VALID_LOTTO_SIZE(6);

    private final int value;
    LottoConstraint(final int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}