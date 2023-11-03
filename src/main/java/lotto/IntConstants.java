package lotto;

public enum IntConstants {
    MIN_RANGE(1),
    MAX_RANGE(45);

    int value;

    IntConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
