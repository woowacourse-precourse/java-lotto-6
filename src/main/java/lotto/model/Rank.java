package lotto.model;

import java.util.Arrays;
import java.util.Map;

public enum Rank {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchingNumber;
    private final int prize;

    Rank(final int matchingNumber, final int prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
    }

    public static Rank find(final int matchingNumber, final boolean bonusMatch) {
        if (isSecondRank(matchingNumber, bonusMatch)) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchingNumber(rank.matchingNumber, matchingNumber))
                .filter(rank -> rank != SECOND)
                .findAny()
                .orElse(NONE);
    }

    public static int calculateTotalReward(final Map<Rank, Integer> resultDetails) {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.prize * resultDetails.get(rank))
                .sum();
    }

    private static boolean isSecondRank(final int matchingNumber, final boolean bonusMatch) {
        return matchingNumber == SECOND.matchingNumber && bonusMatch;
    }

    private static boolean isSameMatchingNumber(final int matchingNumberOfRank, final int matchingNumber) {
        return matchingNumberOfRank == matchingNumber;
    }
}
