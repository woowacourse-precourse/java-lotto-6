package lotto.enums;

import lotto.LottoResult;

public enum LottoPrize {
    MATCH_0(0, 0),
    MATCH_1(0, 1),
    MATCH_2(0, 2),
    MATCH_3(5_000, 3),
    MATCH_4(50_000, 4),
    MATCH_5(1_500_000, 5),
    MATCH_5_BONUS(30_000_000, 5),
    MATCH_6(2_000_000_000, 6);

    private final long prizeMoney;
    private final int matchingNumbers;

    LottoPrize(long prizeMoney, int matchingNumbers) {
        this.prizeMoney = prizeMoney;
        this.matchingNumbers = matchingNumbers;
    }

    public static LottoPrize lottoResultToLottoPrize(LottoResult lottoResult) {
        if (lottoResult.getCount() == 5) {
            if (lottoResult.getBonus()) {
                return MATCH_5_BONUS;
            }
            return MATCH_5;
        }
        for (LottoPrize lottoPrize: values()) {
            if (lottoResult.getCount() == lottoPrize.matchingNumbers) {
                return lottoPrize;
            }
        }
        return null;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}