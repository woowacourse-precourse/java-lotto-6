package lotto.domain.prize;

import lotto.constant.PrizeConstant;

import lotto.domain.lotto.enums.LottoPrize;
import lotto.domain.lotto.enums.LottoRank;

import java.util.EnumMap;

public record Prize(int amount) implements PrizeConstant {
    public static Prize of(EnumMap<LottoRank, Integer> resultBoard) {
        int amount = calculatePrizeWithResultBoard(resultBoard);
        return new Prize(amount);
    }

    private static int calculatePrizeWithResultBoard(EnumMap<LottoRank, Integer> resultBoard) {
        int prize = calculatePrizeWithEachRank(resultBoard);
        return prize;
    }

    private static int calculatePrizeWithEachRank(EnumMap<LottoRank, Integer> resultBoard) {
        int prize = 0;
        for (LottoRank lottoRank : resultBoard.keySet()) {
            prize += resultBoard.get(lottoRank) * LottoPrize.determinePrizeAmountByRank(lottoRank);
        }
        return prize;
    }
}
