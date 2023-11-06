package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NO_MATCH(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean hasBonusNumber;

    Rank(int matchCount, int reward, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank findRankByMatchCount(int countOfMatch, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == countOfMatch
                && rank.hasBonusNumber == hasBonus)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
