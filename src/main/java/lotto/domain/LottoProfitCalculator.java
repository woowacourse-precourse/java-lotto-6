package lotto.domain;

import lotto.util.Constants;
import lotto.util.Prize;

import java.text.DecimalFormat;
import java.util.Map;

public class LottoProfitCalculator {
    private double totalProfitPercentile;

    public LottoProfitCalculator(Map<Integer, Integer> lottoResult, int chance) {
        setTotalProfitPercentile(totalProfit(lottoResult), chance);
    }

    public int totalProfit(Map<Integer, Integer> lottoResult) {
        int totalProfit = 0;

        for (Prize prize : Prize.values()) {
            totalProfit += prize.getPrizeAmount() *
                    lottoResult.getOrDefault(prize.getMatchCount(), 0);
        }
        return totalProfit;
    }

    public void setTotalProfitPercentile(int totalProfit, int chance) {
        totalProfitPercentile = (double) totalProfit / (chance * Constants.MONEY_UNIT);
    }

    public String getTotalProfitPercentile() {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(totalProfitPercentile);
    }
}
