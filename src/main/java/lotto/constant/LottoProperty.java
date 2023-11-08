package lotto.constant;

public enum LottoProperty {
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    LottoProperty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
