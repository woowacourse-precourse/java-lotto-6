package lotto.domain.winningnumbers;

public enum WinningNumbersConfig {
    MINIMUM_RANGE(1),
    MAXIMUM_RANGE(45);

    private final int value;

    WinningNumbersConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
