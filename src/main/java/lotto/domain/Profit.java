package lotto.domain;

import lotto.util.WinnerRank;

public class Profit {
    private final static float HUNDRED_FOR_PERCENT = 100.0f;
    public double calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        float moneyPrize = sumWinMoney(winResult);
        float profit = (moneyPrize / purchasePrice.getPrice()) * HUNDRED_FOR_PERCENT;
        return roundUpProfit(profit);
    }

    private double roundUpProfit (float profit) {
        return Math.round(profit * HUNDRED_FOR_PERCENT)/HUNDRED_FOR_PERCENT;
    }

    private float sumWinMoney(WinResult winResult) {
        float moneyPrize = 0;
        for(WinnerRank winnerRank : WinnerRank.values()){
            int key = winnerRank.getValue();
            moneyPrize += winResult.getWinResultValue(key) * winnerRank.getPrizeMoney();
        }
        return moneyPrize;
    }
}
