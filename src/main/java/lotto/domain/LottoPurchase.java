package lotto.domain;

public class LottoPurchase {
    private int money;
    private int count;

    private LottoPurchase(int money) {
        buyLottos(money);
    }

    public static LottoPurchase of(int money) {
        return new LottoPurchase(money);
    }

    public void buyLottos(int money) {
        this.count = money / 1000;
    }

    public int getCount() {
        return count;
    }
}
