package lotto.domain;

import java.util.Arrays;

public enum LottoPrizeStatus {
    THREE_SAME(5000, 3),
    FOUR_SAME(50000, 4),
    FIVE_SAME(1500000, 5),
    FIVE_SAME_AND_CONTAIN_BONUS(30000000, 5),
    SIX_SAME(2000000000, 6);

    private final int prizeMoney;
    private final int sameCount;

    LottoPrizeStatus(int prizeMoney, int sameCount) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public static LottoPrizeStatus getSatisfiedContainsStatus(int sameCount, boolean isContainBonusNum) {
        LottoPrizeStatus status = null;
        if (sameCount == FIVE_SAME.getSameCount()) {
            return getFiveMatchStatus(isContainBonusNum);
        }
        return getMatchSameCountStatus(sameCount);
    }

    private static LottoPrizeStatus getMatchSameCountStatus(int sameCount) {
        return Arrays.stream(LottoPrizeStatus.values())
                .filter(status -> status.sameCount == sameCount)
                .findFirst()
                .orElse(null);
    }

    private static LottoPrizeStatus getFiveMatchStatus(boolean isContainBonusNum) {
        if (isContainBonusNum) {
            return FIVE_SAME_AND_CONTAIN_BONUS;
        }
        return FIVE_SAME;
    }
}
