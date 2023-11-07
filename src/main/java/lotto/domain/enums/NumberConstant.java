package lotto.domain.enums;

public enum NumberConstant {
    MINIMUM_LOTTO_PRICE(1000),
    ZERO_AMOUNT(0),
    NO_REMAINDER(0),
    INITIAL_VALUE(0),
    ONE_COUNT(1),
    FOR_PERCENT(100),
    ;

    private final int value;

    NumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
