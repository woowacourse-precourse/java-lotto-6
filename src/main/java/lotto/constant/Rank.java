package lotto.constant;

import java.util.Arrays;

public enum Rank {

    FIRST(2000000000, 6, null),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, null),
    FIFTH(5000, 3, null);

    private final long prizeMoney;
    private final int matchCount;
    private final Boolean isMatchBonus;

    Rank(long prizeMoney, int matchCount, Boolean isMatchBonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public static Rank findRank(int matchCount, Boolean isMatchBonus) {
        return Arrays.stream(values())
            .filter(r -> r.matchCount == matchCount)
            .filter(r -> r.isMatchBonus == isMatchBonus || r.isMatchBonus == null)
            .findFirst()
            .orElse(null);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean getMatchBonus() {
        return isMatchBonus;
    }
}
