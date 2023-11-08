package lotto.domain.lotto.enums;

import lotto.constant.PrizeConstant;

public enum LottoPrize implements PrizeConstant {
    FIRST_PRIZE(LottoRank.FIRST, PrizeConstant.FIRST_PRIZE),
    SECOND_PRIZE(LottoRank.SECOND, PrizeConstant.SECOND_PRIZE),
    THIRD_PRIZE(LottoRank.THIRD, PrizeConstant.THIRD_PRIZE),
    FOURTH_PRIZE(LottoRank.FOURTH, PrizeConstant.FOURTH_PRIZE),
    FIFTH_PRIZE(LottoRank.FIFTH, PrizeConstant.FIFTH_PRIZE),
    NONE_PRIZE(LottoRank.NONE, PrizeConstant.NONE_PRIZE);

    private final LottoRank lottoRank;
    private final int prizeAmount;

    LottoPrize(LottoRank lottoRank, int prize) {
        this.lottoRank = lottoRank;
        this.prizeAmount = prize;
    }

    public static int determinePrizeAmountByRank(LottoRank lottoRank) {
        for (LottoPrize prize : values()) {
            if (prize.lottoRank == lottoRank) {
                return prize.prizeAmount;
            }
        }
        return NONE_PRIZE.prizeAmount;
    }
}
