package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NONE(0);

    private static final int MATCH_COUNT_REQUIRED_CHECK_BONUS_NUMBER = 5;

    private final int matchCount;

    LottoRank(int matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoRank find(int matchCount, boolean bonusNumberMatches) {
        if (matchCount == MATCH_COUNT_REQUIRED_CHECK_BONUS_NUMBER) {
            return checkBonusNumberMatches(bonusNumberMatches);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(NONE);
    }

    private static LottoRank checkBonusNumberMatches(boolean bonusNumberMatches) {
        if (bonusNumberMatches) {
            return SECOND;
        }
        return THIRD;
    }
}
