package lotto.utils;

public enum Match {

    THREE(3),
    FOUR(4),
    FIVE(5),
    SIXTH(6);

    private final int value;

    Match(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
