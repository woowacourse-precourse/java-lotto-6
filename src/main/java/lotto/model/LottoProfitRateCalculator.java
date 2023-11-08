package lotto.model;

import java.util.Map.Entry;
import lotto.model.winninglotto.LottoWinningResult;

public class LottoProfitRateCalculator {

    public static double calculateLottoProfitRate(LottoWinningResult lottoWinningResult, int purchaseAmount) {
        int totalAmount = lottoWinningResult.getLottoResult()
            .entrySet()
            .stream()
            .mapToInt(LottoProfitRateCalculator::calculateRankingAmount)
            .sum();

        return (double) totalAmount / purchaseAmount;
    }

    private static Integer calculateRankingAmount(Entry<LottoRanking, Integer> entry) {
        LottoRanking lottoRanking = entry.getKey();
        Integer rankingCount = entry.getValue();
        return lottoRanking.getWinningAmount() * rankingCount;
    }
}
