package lotto.model.enums;

public enum LottoNumber {
    NUMBER_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}