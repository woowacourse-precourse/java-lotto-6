package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private static final int MATCH_COUNT_REQUIRED_CHECK_BONUS_NUMBER = 5;

    private final int matchCount;
    private final int prize;
    private final boolean hasBonusNumber;

    LottoRank(int matchCount, int prize, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRank find(int matchCount, boolean bonusNumberMatches) {
        if (matchCount == MATCH_COUNT_REQUIRED_CHECK_BONUS_NUMBER) {
            return checkBonusNumberMatches(matchCount, bonusNumberMatches);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(NONE);
    }

    private static LottoRank checkBonusNumberMatches(int matchCount, boolean bonusNumberMatches) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.hasBonusNumber == bonusNumberMatches)
                .findAny()
                .orElse(NONE);
    }

    public long multiplyPrize(int count) {
        return (long) prize * count;
    }

    public int matchCount() {
        return matchCount;
    }

    public int prize() {
        return prize;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
