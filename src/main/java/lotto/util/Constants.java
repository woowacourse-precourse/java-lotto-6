package lotto.util;

public enum Constants {
    LOTTO_PRICE(1000);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
