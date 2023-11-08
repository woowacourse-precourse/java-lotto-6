package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final int MATCH_COUNT_REQUIRED_CHECK_BONUS_NUMBER = 5;

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
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

    public long multiplyPrize(int count) {
        return (long) prize * count;
    }

    public int prize() {
        return prize;
    }
}
