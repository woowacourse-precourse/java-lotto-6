package lotto.domain;

import java.util.List;

public class ReturnOnInvestmentCalculator {
    public static long calculateTotalProfit(PrizeStatisticsCalculator prizeCalculator, List<Lotto> lottoList,
                                            Lotto winningLotto) {
        long matchCount = prizeCalculator.getMatchCount(lottoList, winningLotto);
        return matchCount * prizeCalculator.getPrizeMoney();
    }

    public static double calculateProfitRate(long totalProfit, int investment) {
        return (double) totalProfit / investment * 100;
    }
}