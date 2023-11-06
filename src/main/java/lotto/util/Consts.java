package lotto.util;

public enum Consts {
    SINGLE_LOTTO_PRICE(1000);

    private final int value;

    Consts(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
