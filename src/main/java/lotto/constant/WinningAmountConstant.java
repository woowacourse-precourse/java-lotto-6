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

    public static WinningAmountConstant getByCount(int count, boolean hasBonusNumber) {
        if (hasBonusNumber && (count == WinningAmountConstant.SECOND.count)) {
            return WinningAmountConstant.SECOND;
        }

        for (WinningAmountConstant winningAmountConstant : WinningAmountConstant.values()) {
            if (winningAmountConstant.count == count) {
                return winningAmountConstant;
            }
        }

        return null;
    }

    public int getValue() {
        return this.value;
    }

    public int getCount() {
        return this.count;
    }
}
