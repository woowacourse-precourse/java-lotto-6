package lotto.model;

import java.util.Map;

public class ProfitRate {

    private final int payAmount;
    private int totalProfit = 0;
    private double profitRate;

    public ProfitRate(Map<WinningStrategy, Integer> lottoResult, int payAmount) {
        calculateProfit(lottoResult);
        this.payAmount = payAmount;
    }

    private void calculateProfit(Map<WinningStrategy, Integer> matchResult) {
        matchResult.forEach((key, value) -> {
            while (value > 0) {
                totalProfit = WinningStrategy.valueOf(key.name()).calculate(totalProfit);
                value--;
            }
        });
    }

    public double calculateProfitRate(int totalProfit, int payAmount) {
        return roundToTwoDecimalPlaces((double) (totalProfit / payAmount) * 100);
    }

    private double roundToTwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
