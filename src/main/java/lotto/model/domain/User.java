package lotto.model.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private final int purchaseMoney;
    private final int havingLottosCount;
    private long moneyOfReturn;
    private int[] lottoRanks = {0,0,0,0,0,0,0,0};

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

    public void increaseMoneyOfReturn(long returnMoney) {
        this.moneyOfReturn += returnMoney;
    }

    public int[] getLottoRanks() {
        return this.lottoRanks;
    }

    public void increaseUserRank(int identifyNum) {
        if (identifyNum == 10) {
            this.lottoRanks[6]+=1;
            return;
        }
        this.lottoRanks[identifyNum]+=1;
    }

    public long getMoneyOfReturn() {
        return this.moneyOfReturn;
    }
}
