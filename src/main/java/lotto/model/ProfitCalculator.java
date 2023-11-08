package lotto.model;

import lotto.WinningRanking;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class ProfitCalculator {

    private final int lottoPrice;
    private final List<Integer> matchCounts;

    public ProfitCalculator(int lottoPrice, List<Integer> matchCounts) {
        this.lottoPrice = lottoPrice;
        this.matchCounts = matchCounts;
    }

    public BigDecimal calculateProfit() {
        int totalPrize = 0;
        WinningRanking[] ranks = WinningRanking.values();
        for (WinningRanking rank : ranks) {
            if (rank != WinningRanking.LOSING) {
                totalPrize += matchCounts.get(rank.getRank() - 1) * rank.getWinningPrice();
            }
        }

        BigDecimal profitRate = new BigDecimal(totalPrize)
                .divide(new BigDecimal(lottoPrice), MathContext.DECIMAL128)
                .multiply(new BigDecimal(100));

        return profitRate.setScale(1, RoundingMode.HALF_UP);
    }


}
