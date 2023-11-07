package lotto.model;

import lotto.constant.PrizeConstants;

public enum Rank {
    MATCH_3(PrizeConstants.MATCH_3_NUMBER, PrizeConstants.MATCH_3_PRIZE),
    MATCH_4(PrizeConstants.MATCH_4_NUMBER, PrizeConstants.MATCH_4_PRIZE),
    MATCH_5(PrizeConstants.MATCH_5_NUMBER, PrizeConstants.MATCH_5_PRIZE),
    MATCH_5_BONUS(PrizeConstants.MATCH_5_NUMBER, PrizeConstants.MATCH_5_BONUS_PRIZE),
    MATCH_6(PrizeConstants.MATCH_6_NUMBER, PrizeConstants.MATCH_6_PRIZE);

    private final int matchNumber;
    private final int prizeMoney;

    Rank(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumber() {
        return matchNumber;
    }
    public int getprizeMoney() {
        return prizeMoney;
    }


}
