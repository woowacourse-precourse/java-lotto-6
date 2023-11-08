package lotto.enumeration;

public enum NumberRange {
    MIN(1),
    MAX(45),
    LOTTO_NUMBER_COUNT(6);

    private int value;

    private NumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
