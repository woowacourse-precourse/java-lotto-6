package lotto.domain.result;

import java.util.Arrays;

public enum WinningRank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    EMPTY(-1, false, 0);

    private final int count;
    private final boolean bonusNumber;
    private final int money;

    WinningRank(int count, boolean bonusNumber, int money) {
        this.count = count;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    public static WinningRank findWinningRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 5) {
            return Arrays.stream(WinningRank.values())
                    .filter(winningResult -> winningResult.count == matchCount
                            && winningResult.bonusNumber == hasBonusNumber)
                    .findAny()
                    .orElse(EMPTY);
        }
        return Arrays.stream(WinningRank.values())
                .filter(winningResult -> winningResult.count == matchCount)
                .findAny()
                .orElse(EMPTY);
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusNumber() {
        return bonusNumber;
    }
}
