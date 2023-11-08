package lotto.domain.constant;

public enum LottoConstant {
    PRICE(1000),
    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}