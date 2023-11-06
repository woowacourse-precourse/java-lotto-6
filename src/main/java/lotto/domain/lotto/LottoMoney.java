package lotto.domain.lotto;

public class LottoMoney {

    private int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if(money == 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("error");
        }
    }

    public int calculatePurchasableCount() {
        return money / 1000;
    }

    public float calculateProfitRate(float winningMoney) {
        return (winningMoney / money) * 100;
    }
}
