package lotto.model.domain;

public class User {

    private final int purchaseMoney;
    private final float rateOfReturn;

    public User(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        this.rateOfReturn = 0;
    }

    public int getPurchaseMoney() {
        return this.purchaseMoney;
    }

    public float getRateOfReturn() {
        return this.rateOfReturn;
    }
}
