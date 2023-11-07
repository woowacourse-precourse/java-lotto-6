package lotto.utils;

public enum Constants {
    LOTTO_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    PRICE_UNIT(1000);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValues() {
        return value;
    }
}
