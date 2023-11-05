package lotto.domain;

import lotto.util.WinnerRank;

public class Profit {
    private final static int HUNDRED = 100;
    public double calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        return 0f;
    }

    private double roundUpProfit (float profit) {
        return Math.round(profit * HUNDRED)/100.0;
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
