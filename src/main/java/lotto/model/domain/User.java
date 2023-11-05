package lotto.model.domain;

import java.util.ArrayList;

public class User {

    private final int purchaseMoney;
    private final int havingLottosCount;
    private int moneyOfReturn;
    private ArrayList<Integer> lottoRanks;

    public User(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        this.havingLottosCount = purchaseMoney/1000;
        this.moneyOfReturn = 0;
    }

    public int getPurchaseMoney() {
        return this.purchaseMoney;
    }

    public int getHavingLottosCount() {
        return this.havingLottosCount;
    }

    public void increaseMoneyOfReturn(int returnMoney) {
        this.moneyOfReturn += returnMoney;
    }

    public ArrayList<Integer> getLottoRanks() {
        return this.lottoRanks;
    }
}
