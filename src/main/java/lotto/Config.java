package lotto;

public enum Config {
    MIN(1),
    MAX(45);

    private final int value;

    Config(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
