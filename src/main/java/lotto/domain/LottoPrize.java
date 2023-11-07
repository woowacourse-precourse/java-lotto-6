package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIFTH_PRIZE(5000, 3, "3개 일치"),
    FOURTH_PRIZE(50000, 4, "4개 일치"),
    THIRD_PRIZE(1500000, 5, "5개 일치"),
    SECOND_PRIZE(30000000, 5, "5개 일치, 보너스 볼 일치"),
    FIRST_PRIZE(2000000000, 6, "6개 일치");

    private final int prizeMoney;
    private final int sameCount;
    private final String prizeStatement;

    LottoPrize(int prizeMoney, int sameCount, String prizeStatement) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
        this.prizeStatement = prizeStatement;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public String getPrizeStatement() {
        return prizeStatement;
    }

    public static LottoPrize getSatisfiedConditionsStatus(int sameCount, boolean isContained) {
        if (sameCount == THIRD_PRIZE.getSameCount()) {
            return isContainedBonusNum(isContained);
        }
        return getMatchSameCountStatus(sameCount);
    }

    private static LottoPrize getMatchSameCountStatus(int sameCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(status -> status.sameCount == sameCount)
                .findFirst()
                .orElse(null);
    }

    private static LottoPrize isContainedBonusNum(boolean isContainBonusNum) {
        if (isContainBonusNum) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }
}
