package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean containsBonus;
    private final int winningMoney;

    Rank(int matchCount, boolean containsBonus, int winningMoney) {
        this.matchCount = matchCount;
        this.containsBonus = containsBonus;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean containsBonus) {
        return Arrays.stream(values()).filter(rank -> rank.matchCount == matchCount && rank.containsBonus == containsBonus).findFirst().orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isContainsBonus() {
        return containsBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
