package lotto.domain;

public enum LottoConstants {

    NUMBERS_MAX_SIZE(6),
    NUMBER_MAX(45),
    NUMBER_MIN(1),
    THOUSAND(1000),
    ZERO(0);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
