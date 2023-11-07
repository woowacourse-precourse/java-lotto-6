package lotto.constant;

public enum WinningAmountConstant {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3);

    private final int value;
    private final int count;

    WinningAmountConstant(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int value() {
        return this.value;
    }

    public int count() {
        return this.count;
    }
}
