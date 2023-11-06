package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank findRankByMatchCount(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == countOfMatch)
                .findFirst()
                .orElse(null);
    }
}
