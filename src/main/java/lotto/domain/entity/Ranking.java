package lotto.domain.entity;

import java.util.Arrays;

public enum Ranking {
    No(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean isUsingBonusNumber;
    private final int prizeAmount;

    Ranking(int matchCount, boolean isUsingBonusNumber, int prizeAmount) {
        this.matchCount = matchCount;
        this.isUsingBonusNumber = isUsingBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    public static Ranking calcWinningMoney(int matchCount, boolean isMatchingBonus) {
        return Arrays.stream(Ranking.values())
                .filter(prize
                        -> prize.isSameMatchCount(matchCount)
                        && !prize.isUsingBonusNumberAndNotMathed(isMatchingBonus))
                .findAny()
                .orElse(No);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isUsingBonusNumber() {
        return isUsingBonusNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public boolean isUsingBonusNumberAndNotMathed(boolean isMatchingBonus) {
        if (isUsingBonusNumber == true && isMatchingBonus == false) {
            return true;
        }
        return false;
    }
}
