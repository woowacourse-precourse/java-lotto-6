package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NO_PRIZE(0, 0),
    FIFTH_PRIZE(5000, 3),
    FOURTH_PRIZE(50000, 4),
    THIRD_PRIZE(1500000, 5),
    SECOND_PRIZE(30000000, 5, true),
    FIRST_PRIZE(2000000000, 6);

    private static final int DETECT_BONUS = 5;

    private final int prizeMoney;
    private final int lottoBallMatch;
    private final boolean isBonusMatched;

    LottoRank(final int prizeMoney, final int lottoBallMatch, final boolean isBonusMatched) {
        this.prizeMoney = prizeMoney;
        this.lottoBallMatch = lottoBallMatch;
        this.isBonusMatched = isBonusMatched;
    }

    LottoRank(final int prizeMoney, final int lottoBallMatch) {
        this(prizeMoney, lottoBallMatch, false);
    }

    public static LottoRank findLottoRank(final int lottoBallMatch, final boolean bonusMatch) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.checkLottoBallMatch(lottoBallMatch) &&
                    lottoRank.checkBonusMatch(lottoBallMatch, bonusMatch)) {
                return lottoRank;
            }
        }
        return NO_PRIZE;
    }

    private boolean checkLottoBallMatch(final int lottoBallMatch) {
        return (this.lottoBallMatch == lottoBallMatch);
    }

    private boolean checkBonusMatch(final int lottoBallMatch, final boolean isBonusMatched) {
        if (lottoBallMatch != DETECT_BONUS) {
            return true;
        }
        return (this.isBonusMatched == isBonusMatched);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}