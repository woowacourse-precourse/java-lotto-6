package lotto.utils;

public enum NumberConstants {
    NUMBER_LEAST_VALUE(1),
    NUMBER_MOST_VALUE(45),
    NUMBER_COUNT(6);

    private final int value;

    NumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
