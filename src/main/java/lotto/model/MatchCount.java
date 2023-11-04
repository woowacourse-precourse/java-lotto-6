package lotto.model;

import lotto.utils.Constants;

public enum MatchCount {
    THREE_MATCH(3, false, Constants.FIFTH_PRIZE_MONEY),
    FOUR_MATCH(4, false, Constants.FOURTH_PRIZE_MONEY),
    FIVE_MATCH(5, false, Constants.THIRD_PRIZE_MONEY),
    FIVE_AND_BONUS_MATCH(5, true, Constants.SECOND_PRIZE_MONEY),
    SIX_MATCH(6, false, Constants.FIRST_PRIZE_MONEY);

    MatchCount(int matchCount, boolean isBonusMatching, int reward) {
    }


}
