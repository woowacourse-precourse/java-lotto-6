package lotto.constant;

import java.util.LinkedHashMap;

public enum WinningAmountConstant {
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private final int value;
    private final int count;

    WinningAmountConstant(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public static WinningAmountConstant getValueByCount(int count, boolean hasBonusNumber) {
        if (hasBonusNumber && (count == WinningAmountConstant.SECOND.count)) {
            return WinningAmountConstant.SECOND;
        }

        for (WinningAmountConstant winningAmountConstant : WinningAmountConstant.values()) {
            if (winningAmountConstant.count == count) {
                return winningAmountConstant;
            }
        }

        throw new IllegalArgumentException();
    }

    public int getValue() {
        return this.value;
    }

    public int getCount() {
        return this.count;
    }

    public static LinkedHashMap<WinningAmountConstant, Integer> initWinningResult() {
        LinkedHashMap<WinningAmountConstant, Integer> result = new LinkedHashMap<>();

        WinningAmountConstant[] values = WinningAmountConstant.values();

        for (WinningAmountConstant value : values) {
            result.put(value, 0);
        }

        return result;
    }
}
