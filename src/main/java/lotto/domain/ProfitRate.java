package lotto.domain;

import lotto.util.WinnerRank;

import java.math.BigDecimal;

public class ProfitRate {
    private final static float HUNDRED_FOR_PERCENT = 100.0f;

    public String calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        double moneyPrize = sumWinMoney(winResult);
        double profitRate = (moneyPrize / purchasePrice.getPrice()) * HUNDRED_FOR_PERCENT;
        return roundUpProfit(profitRate);
    }

    private String roundUpProfit(double profitRate) {
        profitRate = Math.round(profitRate * HUNDRED_FOR_PERCENT) / HUNDRED_FOR_PERCENT;

        return String.valueOf(new BigDecimal(profitRate));
    }

    private float sumWinMoney(WinResult winResult) {
        float moneyPrize = 0;
        for (WinnerRank winnerRank : WinnerRank.values()) {
            int key = winnerRank.getValue();
            moneyPrize += winResult.getWinResultValue(key) * winnerRank.getPrizeMoney();
        }
        return moneyPrize;
    }
}
