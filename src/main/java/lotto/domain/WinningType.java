package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum WinningType {
    NONE(0,
            0,
            (winningCount, hasBonusNumber) -> winningCount < 3),
    FIFTH(5,
            5000,
            (winningCount, hasBonusNumber) -> winningCount.equals(3)),
    FOURTH(4,
            50000,
            (winningCount, hasBonusNumber) -> winningCount.equals(4)),
    THIRD(3,
            1500000,
            (winningCount, hasBonusNumber) -> winningCount.equals(5) && hasBonusNumber.equals(false)),
    SECOND(2,
            30000000,
            (winningCount, hasBonusNumber) -> winningCount.equals(5) && hasBonusNumber.equals(true)),
    FIRST(1,
            2000000000,
            (winningCount, hasBonusNumber) -> winningCount.equals(6));

    private final int rank;
    private final int price;
    private final BiPredicate<Integer, Boolean> standard;

    WinningType(final int rank, final int price, final BiPredicate<Integer, Boolean> standard) {
        this.rank = rank;
        this.price = price;
        this.standard = standard;
    }

    public static WinningType findWinningType(final int winningCount, final boolean hasBonusNumber) {
        return Arrays.stream(WinningType.values())
                .filter(winning -> winning.standard.test(winningCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }
}
