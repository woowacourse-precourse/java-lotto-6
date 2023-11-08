package lotto.model.winninglotto;

import java.util.EnumMap;
import java.util.Map.Entry;
import lotto.model.LottoRanking;

class LottoProfitRateCalculator {

    static double calculateLottoProfitRate(EnumMap<LottoRanking, Integer> lottoWinningResult, int purchaseAmount) {
        int totalAmount = lottoWinningResult.entrySet()
            .stream()
            .mapToInt(LottoProfitRateCalculator::calculateRankingAmount)
            .sum();

        return (double) totalAmount / purchaseAmount * 100;
    }

    private static Integer calculateRankingAmount(Entry<LottoRanking, Integer> entry) {
        LottoRanking lottoRanking = entry.getKey();
        Integer rankingCount = entry.getValue();
        return lottoRanking.getWinningAmount() * rankingCount;
    }
}
