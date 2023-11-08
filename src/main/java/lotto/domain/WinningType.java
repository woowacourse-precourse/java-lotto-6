package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum WinningType {
    NONE(0,
            false,
            0,
            (winningCount, hasBonusNumber) -> winningCount < 3),
    FIFTH(3,
            false,
            5000,
            (winningCount, hasBonusNumber) -> winningCount.equals(3)),
    FOURTH(4,
            false,
            50000,
            (winningCount, hasBonusNumber) -> winningCount.equals(4)),
    THIRD(5,
            false,
            1500000,
            (winningCount, hasBonusNumber) -> winningCount.equals(5) && hasBonusNumber.equals(false)),
    SECOND(5,
            true,
            30000000,
            (winningCount, hasBonusNumber) -> winningCount.equals(5) && hasBonusNumber.equals(true)),
    FIRST(6,
            false,
            2000000000,
            (winningCount, hasBonusNumber) -> winningCount.equals(6));

    private final int winningCount;
    private final boolean hasBonusNumber;
    private final int price;
    private final BiPredicate<Integer, Boolean> standard;

    WinningType(final int winningCount, final boolean hasBonusNumber, final int price,
                final BiPredicate<Integer, Boolean> standard) {
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
        this.price = price;
        this.standard = standard;
    }

    public static WinningType findWinningType(final int winningCount, final boolean hasBonusNumber) {
        return Arrays.stream(WinningType.values())
                .filter(winning -> winning.standard.test(winningCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    public int getWinningCount() {
        return this.winningCount;
    }

    public boolean hasBonusNumber() {
        return this.hasBonusNumber;
    }

    public int getPrice() {
        return this.price;
    }
}
