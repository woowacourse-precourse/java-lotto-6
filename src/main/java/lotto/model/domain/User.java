package lotto.model.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private final int purchaseMoney;
    private final int havingLottosCount;
    private int moneyOfReturn;
    private int[] lottoRanks;

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

    public int[] getLottoRanks() {
        return this.lottoRanks;
    }

    public void increaseUserRank(int rankIdx) {
        this.lottoRanks[rankIdx]+=1;
    }
}
