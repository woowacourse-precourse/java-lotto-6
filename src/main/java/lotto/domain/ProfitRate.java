package lotto.domain;

import lotto.util.WinnerRank;

import java.math.BigDecimal;

public class ProfitRate {
    private final static float HUNDRED_FOR_PERCENT = 100.0f;
    private final static float TEN_FOR_ROUND_UP = 10.0f;

    public double calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        double moneyPrize = sumWinMoney(winResult);
        double profitRate = (moneyPrize / purchasePrice.getPrice()) * HUNDRED_FOR_PERCENT;
        return roundUpProfit(profitRate);
    }

    private double roundUpProfit(double profitRate) {
        profitRate = Math.round(profitRate * TEN_FOR_ROUND_UP) / TEN_FOR_ROUND_UP;

        return new BigDecimal(profitRate).doubleValue();
    }

    private double sumWinMoney(WinResult winResult) {
        double moneyPrize = 0;
        for (WinnerRank winnerRank : WinnerRank.values()) {
            int key = winnerRank.getValue();
            moneyPrize += winResult.getWinResultValue(key) * winnerRank.getPrizeMoney();
        }
        return moneyPrize;
    }
}
