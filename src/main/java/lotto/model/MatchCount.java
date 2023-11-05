package lotto.model;

import lotto.utils.Constants;

public enum MatchCount {
    DEFAULT_NONE(Constants.ZERO, false, Constants.ZERO),
    THREE_MATCH(3, false, Constants.FIFTH_PRIZE_MONEY),
    FOUR_MATCH(4, false, Constants.FOURTH_PRIZE_MONEY),
    FIVE_MATCH(5, false, Constants.THIRD_PRIZE_MONEY),
    FIVE_AND_BONUS_MATCH(5, true, Constants.SECOND_PRIZE_MONEY),
    SIX_MATCH(6, false, Constants.FIRST_PRIZE_MONEY);

    private final int matchCount;
    private final boolean isBonusMatching;
    private final int reward;

    MatchCount(final int matchCount, final boolean isBonusMatching, final int reward) {
        this.matchCount = matchCount;
        this.isBonusMatching = isBonusMatching;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatching() {
        return isBonusMatching;
    }

    public int getReward() {
        return reward;
    }


}
