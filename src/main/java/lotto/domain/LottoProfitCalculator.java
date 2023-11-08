package lotto.domain;

import lotto.util.Constants;
import lotto.util.Prize;

import java.text.DecimalFormat;
import java.util.Map;

public class LottoProfitCalculator {
    private double totalProfitPercentile;

    public LottoProfitCalculator(Map<Integer, Integer> CountResult, int LottoBuyNum) {
        setTotalProfitPercentile(totalProfit(CountResult), LottoBuyNum);
    }

    private void setTotalProfitPercentile(int totalProfit, int LottoBuyNum) {
        totalProfitPercentile = (double) totalProfit / (LottoBuyNum * Constants.MONEY_UNIT) * Constants.PERCENTAGE_MULTIPLIER;
    }

    private int totalProfit(Map<Integer, Integer> CountResult) {
        int totalProfit = Constants.INIT_VALUE_ZERO;

        for (Prize prize : Prize.values()) {
            totalProfit += prize.getPrizeAmount() *
                    CountResult.getOrDefault(prize.getMatchCount(), Constants.INIT_VALUE_ZERO);
        }
        return totalProfit;
    }

    public String getTotalProfitPercentile() {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(totalProfitPercentile);
    }
}
