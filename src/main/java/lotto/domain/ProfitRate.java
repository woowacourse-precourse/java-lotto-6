package lotto.domain;

import lotto.util.WinnerRank;

public class ProfitRate {
    private final static float HUNDRED_FOR_PERCENT = 100.0f;

    public String calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        float moneyPrize = sumWinMoney(winResult);
        float profitRate = (moneyPrize / purchasePrice.getPrice()) * HUNDRED_FOR_PERCENT;
        return roundUpProfit(profitRate);
    }

    private String roundUpProfit(float profitRate) {
        profitRate = Math.round(profitRate * HUNDRED_FOR_PERCENT) / HUNDRED_FOR_PERCENT;
        return String.valueOf(profitRate);
    }

    private float sumWinMoney(WinResult winResult) {
        float moneyPrize = 0;
        for (WinnerRank winnerRank : WinnerRank.values()) {
            int key = winnerRank.getRankKey();
            moneyPrize += winResult.getWinResultValue(key) * winnerRank.getPrizeMoney();
        }
        return moneyPrize;
    }
}
