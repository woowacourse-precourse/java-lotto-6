package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int winningMoney;
    private final boolean isBonus;

    Rank(int matchCount, int winningMoney, boolean isBonus) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }

    public static Rank valueOf(int matchCount, boolean isBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.isBonus == isBonus)
                .findFirst().orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
