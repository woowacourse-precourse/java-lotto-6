package lotto.model;

import java.text.NumberFormat;
import lotto.utils.Constants;

public enum MatchCount {
    ZERO_MATCH(0, false, Constants.NON_REWARD),
    ONE_MATCH(1, false, Constants.NON_REWARD),
    TWO_MATCH(2, false, Constants.NON_REWARD),
    THREE_MATCH(3, false, Constants.FIFTH_PRIZE_MONEY),
    FOUR_MATCH(4, false, Constants.FOURTH_PRIZE_MONEY),
    FIVE_MATCH(5, false, Constants.THIRD_PRIZE_MONEY),
    FIVE_AND_BONUS_MATCH(5, true, Constants.SECOND_PRIZE_MONEY),
    SIX_MATCH(6, false, Constants.FIRST_PRIZE_MONEY);

    private static final NumberFormat numberFormat = NumberFormat.getInstance();
    private final int matchCount;
    private final boolean isBonusMatching;
    private final long reward;

    MatchCount(final int matchCount, final boolean isBonusMatching, final long reward) {
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

    public long getReward() {
        return reward;
    }

    public String getFormattedReward() {
        return numberFormat.format(reward);
    }

}
