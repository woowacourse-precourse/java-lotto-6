package lotto.domain;

import java.util.Arrays;

public enum LottoPrizeStatus {
    THREE_SAME(5000, 3, "3개 일치"),
    FOUR_SAME(50000, 4, "4개 일치"),
    FIVE_SAME(1500000, 5, "5개 일치"),
    FIVE_SAME_AND_CONTAIN_BONUS(30000000, 5, "5개 일치, 보너스 볼 일치"),
    SIX_SAME(2000000000, 6, "6개 일치");

    private final int prizeMoney;
    private final int sameCount;

    private final String matchInformation;

    LottoPrizeStatus(int prizeMoney, int sameCount, String matchInformation) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
        this.matchInformation = matchInformation;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public String getMatchInformation() {
        return matchInformation;
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
