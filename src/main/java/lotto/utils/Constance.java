package lotto.utils;

public enum Constance {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_MAX_LENGTH(6);

    private final int value;

    Constance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
