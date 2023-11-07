package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;

    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(long matchCount, boolean matchWithBonusNumber) {
        if (matchCount == SECOND.matchCount && matchWithBonusNumber) {
            return SECOND;
        }
        if (matchCount == SECOND.matchCount && !matchWithBonusNumber) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
