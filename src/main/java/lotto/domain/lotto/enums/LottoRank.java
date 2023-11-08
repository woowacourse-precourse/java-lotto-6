package lotto.domain.lotto.enums;

import lotto.constant.LottoConstant;
import lotto.domain.result.MatchResult;

public enum LottoRank implements LottoConstant {
    FIRST(PICK_COUNT, false),
    SECOND(PICK_COUNT - 1, true),
    THIRD(PICK_COUNT - 1, false),
    FOURTH(PICK_COUNT - 2, false),
    FIFTH(PICK_COUNT - 3, false),
    NONE(0, false);

    private final int matchCount;
    private final boolean matchBonus;

    LottoRank(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.matchBonus = bonusMatch;
    }

    public static LottoRank determineRankByMatchResult(MatchResult matchResult) {
        int matchCount = matchResult.matchCount();
        boolean matchBonus = matchResult.matchBonus();
        if (isMatchBonusNeedForDistinction(matchCount, matchBonus)) {
            matchCount += 1;
            matchBonus = false;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.matchBonus || matchBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    private static boolean isMatchBonusNeedForDistinction(int matchCount, boolean matchBonus) {
        return matchCount != PICK_COUNT - 1 && matchBonus == true;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean isMatchBonus() {
        return this.matchBonus;
    }
}
