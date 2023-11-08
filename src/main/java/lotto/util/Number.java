package lotto.util;

public enum Number {
    THOUSAND(1000);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
