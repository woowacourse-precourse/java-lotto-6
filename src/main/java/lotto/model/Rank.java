package lotto.model;

import java.util.Arrays;

public enum Rank {

    NONE(0),
    FIFTH(3),
    FOURTH(4),
    THIRD(5),
    SECOND(5, true),
    FIRST(6);

    private final int matchingNumber;
    private final boolean bonusMatch;

    Rank(int matchingNumber) {
        this.matchingNumber = matchingNumber;
        bonusMatch = false;
    }

    Rank(int matchingNumber, boolean bonusMatch) {
        this.matchingNumber = matchingNumber;
        this.bonusMatch = bonusMatch;
    }

    public static Rank find(int matchingNumber, boolean bonusMatch) {
        if (isEqualsToSecondRankMatchingNumber(matchingNumber, bonusMatch)) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchingNumber(rank.matchingNumber, matchingNumber))
                .filter(rank -> rank != SECOND)
                .findAny()
                .orElse(NONE);
    }

    private static boolean isEqualsToSecondRankMatchingNumber(int matchingNumber, boolean bonusMatch) {
        return matchingNumber == SECOND.matchingNumber && bonusMatch == SECOND.bonusMatch;
    }

    private static boolean isSameMatchingNumber(int matchingNumberOfRank, int matchingNumber) {
        return matchingNumberOfRank == matchingNumber;
    }
}
