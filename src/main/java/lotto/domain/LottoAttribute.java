package lotto.domain;

public enum LottoAttribute {
    LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private final int value;

    LottoAttribute(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
