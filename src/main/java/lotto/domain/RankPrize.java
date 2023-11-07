package lotto.domain;

import static lotto.domain.enums.RankPrizeMessage.DEFAULT_RANK;
import static lotto.domain.enums.RankPrizeMessage.WITH_BONUS_RANK;

import java.util.Arrays;

public enum RankPrize {
    FIFTH_PLACE(DEFAULT_RANK.getMessage(), 3, 5_000),
    FOURTH_PLACE(DEFAULT_RANK.getMessage(), 4, 50_000),
    THIRD_PLACE(DEFAULT_RANK.getMessage(), 5, 1_500_000),
    SECOND_PLACE(WITH_BONUS_RANK.getMessage(), 5, 30_000_000),
    FIRST_PLACE(DEFAULT_RANK.getMessage(), 6, 2_000_000_000),
    ;

    private final String rankMessage;
    private final int matchCounts;
    private final int prizeAmount;

    RankPrize(String rankMessage, int matchCount, int prizeAmount) {
        this.rankMessage = rankMessage;
        this.matchCounts = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public static RankPrize determineRankPrize(int matchCounts, boolean isBonusMatched) {
        if (SECOND_PLACE.isMatch(matchCounts)) {
            return determineSecondOrThird(isBonusMatched);
        }
        return Arrays.stream(values())
                .filter(rankPrize -> rankPrize.isMatch(matchCounts))
                .findFirst()
                .orElse(null);
    }

    private boolean isMatch(int matchCounts) {
        return this.matchCounts == matchCounts;
    }

    private static RankPrize determineSecondOrThird(boolean isBonusMatched) {
        if (isBonusMatched) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }

    public String getRankMessage() {
        return rankMessage;
    }

    public int getMatchCounts() {
        return matchCounts;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
