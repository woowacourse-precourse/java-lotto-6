package lotto.domain;

import java.util.Arrays;

import static lotto.constant.NumberConstants.*;

public enum LottoRank {
    NO_RANK(0, 0, false),
    FIFTH_RANK(FIFTH_RANK_MATCH, FIFTH_PRIZE_MONEY, false),
    FORTH_RANK(FOURTH_RANK_MATCH, FORTH_PRIZE_MONEY, false),
    THIRD_RANK(THIRD_RANK_MATCH, THIRD_PRIZE_MONEY, false),
    SECOND_RANK(SECOND_RANK_MATCH, SECOND_PRIZE_MONEY, true),
    FIRST_RANK(FIRST_RANK_MATCH, FIRST_PRIZE_MONEY, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean isMatchBonus;

    LottoRank(int matchCount, int prizeMoney, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isMatchBonus = isMatchBonus;
    }

    public static LottoRank checkRank(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> isPrize(rank, matchCount, isMatchBonus))
                .findAny()
                .orElse(NO_RANK);
    }

    private static boolean isPrize(LottoRank rank, int matchCount, boolean isMatchBonus) {
        if (rank.matchCount != matchCount) {
            return false;
        }
        if (SECOND_RANK_MATCH == matchCount) {
            return rank.isMatchBonus == isMatchBonus;
        }
        return true;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
