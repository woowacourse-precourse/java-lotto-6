package lotto.domain;

import lotto.util.WinnerRank;

public class Profit {

    public float calculateProfitRate(PurchasePrice purchasePrice, WinResult winResult) {
        return 0f;
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
