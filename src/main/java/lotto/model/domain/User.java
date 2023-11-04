package lotto.model.domain;

public class User {

    private final int purchaseMoney;
    private final float rateOfReturn;
    private final int havingLottosCount;

    public User(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        this.havingLottosCount = purchaseMoney/1000;
        this.rateOfReturn = 0;
    }

    public int getPurchaseMoney() {
        return this.purchaseMoney;
    }

    public float getRateOfReturn() {
        return this.rateOfReturn;
    }

    public int getHavingLottosCount() {
        return this.havingLottosCount;
    }
}
