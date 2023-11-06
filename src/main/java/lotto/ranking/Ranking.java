package lotto.ranking;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOTHING(0, 0, false);

    private final int matchCount;
    private final int price;
    private final boolean isBonusMatch;

    Ranking(int matchCount, int price, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.price = price;
        this.isBonusMatch = isBonusMatch;
    }

    public static Ranking calculateRanking(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.isMatchRankingCondition(matchCount, isBonusMatch))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isMatchRankingCondition(int matchCount, boolean isBonusMatch) {
        if (this.equals(Ranking.SECOND)) {
            return this.matchCount == matchCount && isBonusMatch;
        }
        return this.matchCount == matchCount;
    }

    public Integer calculatePrize(int rankCount) {
        return rankCount * price;
    }
}
