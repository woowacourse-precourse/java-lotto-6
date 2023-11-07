package lotto.domain;

import lotto.util.WinnerRank;

public class Profit {
    private final static float HUNDRED_FOR_PERCENT = 100.0f;

    public String calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        float moneyPrize = sumWinMoney(winResult);
        float profit = (moneyPrize / purchasePrice.getPrice()) * HUNDRED_FOR_PERCENT;
        return roundUpProfit(profit);
    }

    private String roundUpProfit(float profit) {
        float profitRate = Math.round(profit * HUNDRED_FOR_PERCENT) / HUNDRED_FOR_PERCENT;
        return String.valueOf(profitRate);
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
