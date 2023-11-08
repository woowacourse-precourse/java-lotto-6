package lotto.constant;

import java.util.LinkedHashMap;
import java.util.Optional;

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

    public static Optional<WinningAmountConstant> getValueByCount(int count, boolean hasBonusNumber) {
        if (hasBonusNumber && (count == WinningAmountConstant.SECOND.count)) {
            return Optional.of(WinningAmountConstant.SECOND);
        }

        for (WinningAmountConstant winningAmountConstant : WinningAmountConstant.values()) {
            if (winningAmountConstant.count == count) {
                return Optional.of(winningAmountConstant);
            }
        }

        return Optional.empty();
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
