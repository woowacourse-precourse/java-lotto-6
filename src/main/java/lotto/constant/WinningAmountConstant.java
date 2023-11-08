package lotto.constant;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<WinningAmountConstant, Integer> initWinningResult() {
        HashMap<WinningAmountConstant, Integer> result = new HashMap<>();

        WinningAmountConstant[] values = WinningAmountConstant.values();

        for (WinningAmountConstant value : values) {
            result.put(value, 0);

        }

        return result;
    }
}
