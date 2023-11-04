package lotto.common;

public enum Range {
    START(1),
    END(45);

    private final int value;

    Range(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
