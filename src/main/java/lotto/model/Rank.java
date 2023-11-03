package lotto.model;

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

    public static boolean isEqualsToFirstRankMatchingNumber(int matchingNumber) {
        return matchingNumber == FIRST.matchingNumber;
    }

    public static boolean isEqualsToSecondRankMatchingNumber(int matchingNumber) {
        return matchingNumber == SECOND.matchingNumber;
    }

    public static boolean isEqualsToThirdRankMatchingNumber(int matchingNumber) {
        return matchingNumber == THIRD.matchingNumber;
    }

    public static boolean isEqualsToFourthRankMatchingNumber(int matchingNumber) {
        return matchingNumber == FOURTH.matchingNumber;
    }

    public static boolean isEqualsToFifthRankMatchingNumber(int matchingNumber) {
        return matchingNumber == FIFTH.matchingNumber;
    }

    public static boolean isSameBonus(boolean bonusMatch) {
        return bonusMatch == SECOND.bonusMatch;
    }
}
