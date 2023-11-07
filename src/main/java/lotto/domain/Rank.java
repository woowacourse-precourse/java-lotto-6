package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(1, 6, 0, 2000000000),
    SECOND(2, 5, 1, 30000000),
    THIRD(3, 5, 0, 1500000),
    FORTH(4, 4, 0, 50000),
    FIFTH(5, 3, 0, 5000),
    LOSER(0, 0, 0, 0);

    private final int place;
    private final int matchingNumberCount;
    private final int matchingBonusNumberCount;
    private final int prize;

    Rank(int place, int matchingNumberCount, int matchingBonusNumberCount, int prize) {
        this.place = place;
        this.matchingNumberCount = matchingNumberCount;
        this.matchingBonusNumberCount = matchingBonusNumberCount;
        this.prize = prize;
    }

    public static Rank findByMatchingNumber(int matchingNumberCount, int matchingBonusNumberCount) {
        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.matchingNumberCount == matchingNumberCount
                        && rank.matchingBonusNumberCount <= matchingBonusNumberCount)
                .findFirst()
                .orElse(LOSER);
    }

    public int getPlace() {
        return place;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getMatchingBonusNumberCount() {
        return matchingBonusNumberCount;
    }
}
