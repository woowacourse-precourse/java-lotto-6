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

    private void setTotalProfitPercentile(int totalProfit, int chance) {
        totalProfitPercentile = (double) totalProfit / (chance * Constants.MONEY_UNIT) * Constants.PERCENTAGE_MULTIPLIER;
    }

    private int totalProfit(Map<Integer, Integer> lottoResult) {
        int totalProfit = Constants.INIT_VALUE_ZERO;

        for (Prize prize : Prize.values()) {
            totalProfit += prize.getPrizeAmount() *
                    lottoResult.getOrDefault(prize.getMatchCount(), Constants.INIT_VALUE_ZERO);
        }
        return totalProfit;
    }

    public String getTotalProfitPercentile() {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(totalProfitPercentile);
    }
}
