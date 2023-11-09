package lotto.domain;

public enum LottoEnum {
    LOTTO_PRICE(1000),
    LOTTO_COUNT(6),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
