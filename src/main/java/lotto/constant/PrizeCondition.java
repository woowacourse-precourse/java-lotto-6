package lotto.constant;

public enum PrizeCondition {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    LOSE(2, false);

    private final int matchNumbers;
    private final boolean bonusMatch;

    PrizeCondition(int matchNumbers, boolean bonusMatch) {
        this.matchNumbers = matchNumbers;
        this.bonusMatch = bonusMatch;
    }

    int getMatchNumbers() {
        return this.matchNumbers;
    }

    public static PrizeCondition findPrize(int matchNumbers, boolean bonusMatch) {
        if (matchNumbers <= LOSE.matchNumbers) {
            return LOSE;
        }
        if (matchNumbers <= FIFTH.matchNumbers) {
            return FIFTH;
        }
        if (matchNumbers <= FOURTH.matchNumbers) {
            return FOURTH;
        }
        if (matchNumbers == FIRST.matchNumbers) {
            return FIRST;
        }
        return distinguishSecondOrThird(bonusMatch);
    }

    static PrizeCondition distinguishSecondOrThird(boolean bonusMatch) {
        if (bonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

}
